package lotto;

public class Util {

    public static boolean isNumberic(final String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }
}
