package lotto.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constValue.Constants.ExceptionMessage.*;

public class LottoException {


    public void checkMoneyInput(String moneyInput){
        checkMoneyInputNumber(moneyInput);
        checkMoneyInputThousand(moneyInput);
    }

    private static void checkMoneyInputNumber(String moneyInput){
        if(isMoneyInputNumberCheck(moneyInput)){
            return;
        }
        throw new IllegalArgumentException(MONEY_Input_Number_ERROR_MESSAGE);
    }

    private static boolean isMoneyInputNumberCheck(String moneyInput){
        boolean found=false;

        String regex="^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(moneyInput);

        if(matcher.matches()){
            found=true;
        }
        return found;
    }

    private static void checkMoneyInputThousand(String moneyInput){
        if(isMoneyInputThousand(moneyInput)){
            return;
        }
        throw new IllegalArgumentException(MONEY_Input_THOUSAND_ERROR_MESSAGE);
    }

    private static boolean isMoneyInputThousand(String moneyInput){
        String thousand = moneyInput.substring(moneyInput.length()-3,moneyInput.length());
        if(thousand.equals("000")){
            return true;
        }
        return false;
    }

}
