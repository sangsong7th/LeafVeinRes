package http.request;

import http.aop.NettyToBean;
import http.aop.Scanner;
import http.entity.FileBuildEnity;
import http.entity.FileTraversalEnity;
import impl.userlevel.FileBuildServiceImpl;
import impl.userlevel.FileTraversalImpl;
import Service.userlevel.FileBuildService;
import Service.systemlevel.FileTraversal;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.CharsetUtil;
import utill.StringUnit;

import java.net.InetAddress;
import java.util.List;

/**
 *
 * Title: NettyServerHandler
 * Description: 服务端业务逻辑
 * Version:1.0.0
 * @author pancm
 * @date 2017年10月26日
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    private String result="";
    /*
     * 收到消息时，返回信息
     */


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(! (msg instanceof FullHttpRequest)){
            result="未知请求!";
            send(ctx,result,HttpResponseStatus.BAD_REQUEST);
            return;
        }
        FullHttpRequest httpRequest = (FullHttpRequest)msg;

        try{
            String path=httpRequest.uri();          //获取路径
            String body = getBody(httpRequest);     //获取参数
            HttpMethod method=httpRequest.method();//获取请求方法

            System.out.println(path);
            List<String> pathTemp=StringUnit.stringSplit(path,"\\?");
            List<String> paths= StringUnit.stringSplit(pathTemp.get(0),"/");
            System.out.println("接收到:"+method+" 请求");

            if(HttpMethod.GET.equals(method)){
                //接受到的消息，做业务逻辑处理...
                QueryStringDecoder decoder= new QueryStringDecoder(httpRequest.uri());

                System.out.println("body:"+decoder);
                Scanner scanner=new Scanner();

                String result=null;

                if(paths.get(paths.size()-1).equals("buildclasspaths")){
                    FileBuildService fIleBuild=new FileBuildServiceImpl();
                    FileBuildEnity fileBuildEnity= (FileBuildEnity) NettyToBean.getchange(decoder, FileBuildEnity.class);
                    result=fIleBuild.BuildClassPaths(StringUnit.getStrbyBase64(fileBuildEnity.getClassifyStr()),StringUnit.getStrbyBase64(fileBuildEnity.getClassRoot()))?"true":"false";

                }

                if(paths.get(paths.size()-1).equals("filepathcurrentlist")){
                    FileTraversal fileTraversal=new FileTraversalImpl();
                    FileTraversalEnity fileTraversalEnity= (FileTraversalEnity) NettyToBean.getchange(decoder,FileTraversalEnity.class);
                    result=fileTraversal.FilePathCurrentList(fileTraversalEnity.getFilePath());
                }

                //Test test= (Test) NettyToBean.getchange(decoder,Test.class);



                send(ctx,result,HttpResponseStatus.OK);
                return;
            }
            //如果是POST请求
            if(HttpMethod.POST.equals(method)){
                //接受到的消息，做业务逻辑处理...
                HttpPostRequestDecoder decoder=new HttpPostRequestDecoder(httpRequest);
                System.out.println("body:"+decoder);
                result="POST请求";

                send(ctx,result,HttpResponseStatus.OK);
                return;
            }
        }catch(Exception e){
            System.out.println("处理请求失败!");
            e.printStackTrace();
        }finally{
            //释放请求
            httpRequest.release();
        }
    }
    /**
     * 获取body参数
     * @param request
     * @return
     */
    private String getBody(FullHttpRequest request){
        ByteBuf buf = request.content();
        return buf.toString(CharsetUtil.UTF_8);
    }

    /**
     * 发送的返回值
     * @param ctx     返回
     * @param context 消息
     * @param status 状态
     */
    private void send(ChannelHandlerContext ctx, String context,HttpResponseStatus status) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, Unpooled.copiedBuffer(context, CharsetUtil.UTF_8));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain; charset=UTF-8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        ctx.writeAndFlush("客户端"+ InetAddress.getLocalHost().getHostName() + "成功与服务端建立连接！ ");
        super.channelActive(ctx);
    }
}