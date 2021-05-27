package utill;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

import static sun.security.pkcs11.wrapper.Functions.toHexString;

/**
 * <p>文件处理相关的工具类</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
public class FIleUnit {

    public static boolean createDir(String path){
        File file=new File(path);
        if(!file.exists()){
            return file.mkdirs();
        }
        return false;
    }

    public static String getMd5(String filePath){

        File file=new File(filePath);

        FileInputStream fileInputStream = null;

        try {
            MessageDigest MD5 = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[8192];

            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                MD5.update(buffer, 0, length);
            }
            return new String(toHexString(MD5.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean outputJSONString(String jsonString,String path) {

        File file = new File(path) ;
        if(!file.exists()){
            try {
                file.createNewFile() ;
            } catch (IOException e) {
                e.printStackTrace();
                file.delete();
            }
        }
        FileOutputStream fos = null;
        int rtn =0 ;
        try {

            fos = new FileOutputStream(file,false);
            FileChannel fc = fos.getChannel();

            ByteBuffer bbf = ByteBuffer.wrap(jsonString.getBytes());
            bbf.put(jsonString.getBytes()) ;
            bbf.flip();
            fc.write(bbf) ;

            fc.close();
            fos.flush();
            fos.close();
        }catch (IOException e) {
            rtn = 1 ;
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    public static Long getSize(String pathname){
            FileChannel fc= null;
            try {
                File f= new File(pathname);
                if (f.exists() && f.isFile()){
                    FileInputStream fis= new FileInputStream(f);
                    fc= fis.getChannel();
                    return fc.size();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null!=fc){
                    try{
                        fc.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        return 0L;
    }
}
