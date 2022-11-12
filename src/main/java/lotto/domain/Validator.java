package lotto.domain;

import java.util.regex.Pattern;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class Validator {
    static final int LOTTO_LOWER_BOUND = 1;
    static final int LOTTO_UPPER_BOUND = 45;
    public void validateInputAmount(String input){
        validateNumeric(input);
        validateGraterThousand(input);
        validateMultipleOfThousands(input);
    }

    public void validateBonusNumber(String input){
        validateNumeric(input);
        validateLottoNumberBound(input);
    }

    public void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 형태가 아닙니다");
        }
    }
    public void validateGraterThousand(String input){
        int amount = Integer.parseInt(input);
        if(amount < 1000){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000원 미만입니다.");
        }
    }

    public void validateMultipleOfThousands(String input){
        int amount = Integer.parseInt(input);
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000의 단위가 아닙니다.");
        }
    }

    public void validateLottoNumberBound(String input){
        int bonusNumber = Integer.parseInt(input);
        if(bonusNumber < LOTTO_LOWER_BOUND || bonusNumber > LOTTO_UPPER_BOUND){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1-45 사이의 범위가 아닙니다");
        }
    }

}
