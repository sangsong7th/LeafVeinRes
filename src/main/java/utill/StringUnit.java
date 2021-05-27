package utill;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * <p>文件处理相关的工具类</p>
 * @author sangsong6th
 * @since 2021/5/27
 */
public class StringUnit {

    final static private Base64.Encoder encoder = Base64.getEncoder();
    final static private Base64.Decoder decoder = Base64.getDecoder();

    /**
     * <p>分割字符串并返回字符串数组</p>
     * @param str
     * @param splitStr
     * @param number
     * @return
     */
    public static String[] stringSplit(String str,String splitStr,int number){
        String[] strings = new String[number];
        if (str!=null) {
            String[] stringTemp = str.split(splitStr);
            if (stringTemp.length <= number) {
                for (int i = 0; i < stringTemp.length; i++) {
                    strings[i] = stringTemp[i];
                }
            } else {
                for (int i = 0; i < number; i++) {
                    strings[i] = stringTemp[i];
                }
            }
        }
        return strings;
    }


    /**
     * <p>分割字符串并返回list</p>
     * @param str
     * @param splitStr
     * @return
     */
    public static List<String> stringSplit(String str, String splitStr){
        List<String> strings=new ArrayList<>();
        if(str!=null){
            String[] stringTemp= str.split(splitStr);
            if(stringTemp.length!=0){
                for(int i = 0;i<stringTemp.length;i++){
                    strings.add(stringTemp[i]);
                }
            }else{
                return null;
            }
        }
        return  strings;
    }

    /**
     * <p>进行判空操作</p>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str==null||str.equals("")){
            return false;
        }
        return true;
    }

    public static boolean hasEmptyOne(String...strings){

        for(String str:strings){
            if(str==null||str.equals("")){
                return false;
            }
        }
        return true;

    }

    public static String getBase64(String str) throws UnsupportedEncodingException {


        //final String text = "字串文字";
        byte[] textByte = str.getBytes("UTF-8");

        String encodedText = encoder.encodeToString(textByte);

        System.out.println(encodedText);
        //System.out.println(new String(decoder.decode(encodedText), "UTF-8"));

        return encodedText;
    }

    public static String getStrbyBase64(String base64) throws UnsupportedEncodingException {

        return new String(decoder.decode(base64), "UTF-8");
    }

}
