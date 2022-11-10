package lotto.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constValue.Constants.ExceptionMessage.*;

public class LottoException {


    public void checkBuyInput(String buyInput){
        checkBuyInputNumber(buyInput);
        checkBuyInputThousand(buyInput);
    }

    public void checkBuyInputNumber(String buyInput){
        if(isBuyInputNumberCheck(buyInput)){
            return;
        }
        throw new IllegalArgumentException(Buy_Input_Number_ERROR_MESSAGE);
    }

    public boolean isBuyInputNumberCheck(String buyInput){
        boolean found=false;

        String regex="^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(buyInput);

        if(matcher.matches()){
            found=true;
        }
        return found;
    }

    public void checkBuyInputThousand(String buyInput){
        if(isBuyInputThousand(buyInput)){
            return;
        }
        throw new IllegalArgumentException(Buy_Input_THOUSAND_ERROR_MESSAGE);
    }

    public boolean isBuyInputThousand(String buyInput){
        String thousand = buyInput.substring(buyInput.length()-3,buyInput.length());
        if(thousand.equals("000")){
            return true;
        }
        return false;
    }

}
