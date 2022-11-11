package lotto;

import net.bytebuddy.pool.TypePool;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Util {

    public static boolean isNumberic(final String str){
        try{
            Double.parseDouble(str);
            return true;
        }catch (NumberFormatException nfe){
            return false;
        }
    }

    public static boolean isDividedBuyThousand(final String input){
        final BigInteger convertInput = new BigInteger(input);
        final BigInteger thousand = BigInteger.valueOf(1000);
        final BigInteger remainderInput = convertInput.remainder(thousand);

        if (remainderInput.compareTo(BigInteger.ZERO) == 0){
            return true;
        }
        return false;
    }

    public static int countChar(final String input, final char ch){
        final int count = (int)input.chars()
                .filter(c -> c == ch)
                .count();

        return count;
    }

    public static List<Integer> splitInteger(final String input, final String sep) throws IllegalArgumentException {
        List<Integer> lottoNumbers = new ArrayList<>();

        try{
            for (String number : input.split(sep)){
                CheckInputException.checkBuyerInputIsNotNumber(number);
                Integer tmpNumber = Integer.valueOf(number);
                lottoNumbers.add(tmpNumber);
            }
        } catch(IllegalArgumentException iae){
            throw iae;
        }
        return lottoNumbers;
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
