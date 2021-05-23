package http.aop;

import io.netty.handler.codec.http.QueryStringDecoder;

import java.lang.reflect.Field;

public class NettyToBean {


    public static Object getchange(QueryStringDecoder decoder, Class clazz ) throws  IllegalAccessException, InstantiationException {

        Object o=clazz.newInstance();

        decoder.parameters().entrySet().forEach(

                entry ->{

                    try {

                        Field field=clazz.getDeclaredField(entry.getKey());
                        field.setAccessible(true);
                        field.set(o,entry.getValue().get(0));

                    } catch (NoSuchFieldException e) {

                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

        );

        return o;

    }

    public static Object post(String packageName){
        return null;
    }
}
