package utill;

import annotation.WillBeOptimized;

import java.io.*;

@WillBeOptimized(value = "")
public class CMDSender implements Runnable{

    private PipedOutputStream out = null;
    private String order=null;
    private boolean flag=false;
    private boolean classFlag=true;

    public CMDSender(String order){
        this.order=order;
        this.flag=true;
    }

    public PipedOutputStream getPipedOutputStream() {
        out = new PipedOutputStream();
        return  out;
    }

    public void changeOrder(String order){
        this.order=order;
        this.flag=true;
    }

    public void run() {
        while (this.classFlag) {

            if (this.order != null && this.flag != false) {


                try {
                    Runtime runtime = Runtime.getRuntime();
                    Process process = runtime.exec(this.order);
                    InputStream is = process.getInputStream();

                    InputStreamReader isr = new InputStreamReader(is, "gbk");
                    BufferedReader br = new BufferedReader(isr);

                    String line;

                    while ((line = br.readLine()) != null) {
                        out.write(line.getBytes());
                        System.out.println(line);
                        out.flush();
                        Thread.sleep(100);

                    }

                    is.close();
                    isr.close();
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    this.flag=false;
                }

            }
        }

    }


    public void disappor() throws IOException {
        out.close();
        this.classFlag=false;
    }

}
