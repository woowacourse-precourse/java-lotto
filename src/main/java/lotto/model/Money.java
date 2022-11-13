package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constValue.Constants.ExceptionMessage.MONEY_INPUT_NON_Number_ERROR_MESSAGE;
import static lotto.constValue.Constants.ExceptionMessage.MONEY_INPUT_NON_THOUSAND_ERROR_MESSAGE;

public class Money {

    private final String money;

    public Money(String money){
        validateMoneyInput(money);
        this.money = money;
    }

    public void validateMoneyInput(String moneyInput){
        validateMoneyInputNumber(moneyInput);
        validateMoneyInputThousand(moneyInput);
    }

    private static void validateMoneyInputNumber(String moneyInput){
        if(isMoneyInputNumberCheck(moneyInput)){
            return;
        }
        throw new IllegalArgumentException(MONEY_INPUT_NON_Number_ERROR_MESSAGE);
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

    private static void validateMoneyInputThousand(String moneyInput){
        if(isMoneyInputThousand(moneyInput)){
            return;
        }
        throw new IllegalArgumentException(MONEY_INPUT_NON_THOUSAND_ERROR_MESSAGE);
    }

    private static boolean isMoneyInputThousand(String moneyInput){
        if(moneyInput.contains("000")){
            return true;
        }
        return false;
    }
}
