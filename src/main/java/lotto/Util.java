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

    public static boolean isDividedBuyThousand(String input){
        long convertInput = Long.valueOf(input);

        if (convertInput % 1000 == 0){
            return true;
        }
        return false;
    }

    /*public static long dividedBuy1000(final String input){
        final long longInput = Long.valueOf(input);
        final int thousand = 1000;
        long quotient = 0;

        if (longInput % thousand == 0 && longInput == 0) {
            quotient = (long)(longInput / thousand);
            return longInput / thousand;
        }
        return quotient;
    }*/
}
