package lotto.domain.validator;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.util.ErrorMessages;

public class LottoNumberValidator {
//    public void validateFomula(final String inputValue){
//        checkingSeparator(inputValue);
//        checkingNotNumber(inputValue);
//        checkingRange(inputValue);
//        checkingOverlap(inputValue);
//        checkingQuantity(inputValue);
//    }
//    public void validateBonus(final String inputValue){
//        checkingNotNumber(inputValue);
//        checkingRange(inputValue);
//    }


    // 1차 : 쉼표로 split했는데 다른 구분자 있을 때
    public void checkingSeparator(final String inputValue){
        String[] splitValues = inputValue.split(",");
        for (String value : splitValues){
            value = value.trim();
            if(!value.matches("[0-9a-zA-Z]")){
                throw new IllegalArgumentException(ErrorMessages.WRONG_SEPARATOR.getMessage());
            }
        }
    }

}
