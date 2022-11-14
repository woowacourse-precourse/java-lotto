package lotto.validate;

import java.util.ArrayList;
import java.util.List;

public class UserValidate {
    static final String NOT_NUMBER_ERROR_MSG = "[ERROR] 숫자를 입력해주세요!";
    static final String UNDER_THAN_LOTTO_CHARGE_ERROR_MSG ="[ERROR] 로또 1장의 구매가격은 1000원 입니다! 1000이상의 수를 입력해주세요";
    static final String UNIT_ERROR_MSG ="[ERROR] 1000 단위로 입력해주세요!";
    static final String CIPHER_ERROR_MSG = "[ERROR] 콤마를 기준으로 6자리를 입력해주세요!";
    static final String NOT_NUMBER_ERROR_IN_WINNING_NUMBER_MSG = "[ERROR] 콤마를 기준으로 숫자만 입력해주세요!";
    static final String DUPLICATE_NUMBER_ERROR_MSG = "[ERROR] 중복된 숫자를 입력했습니다!";
    static final String RANGE_ERROR_MSG = "[ERROR] 1~45범위로 숫자를 입력해주세요!";
    static final String BONUS_NUMBER_IN_WINNING_NUMBER_ERROR_MSG ="[ERROR] 당첨 번호에 없는 숫자를 입력해주세요!";
    static final char CHAR_COMMA = ',';
    static final String STRING_COMMA = ",";
    static final int NUMBER_OF_COMMA = 5;
    static final int LOTTO_CHARGE = 1000;

    public void validateMoney(String money){
        isNumberValidate(money);
        minimumRangeValidate(money);
        unitValidate(money);
    }

    public void validateWinningNumbers(String winningNumbers){
        numberOfInputsValidate(winningNumbers);
        isNumberValidateWinningNumbers(winningNumbers);
        duplicateValidate(winningNumbers);
        rangeValidateWinninNumbers(winningNumbers);
    }

    public void validateBonusNumber(List<Integer> winningNumbers , String bonusNumber){
        isNumberValidate(bonusNumber);
        rangeValidate(bonusNumber);
        bonusNumberInWinningNumbers(winningNumbers,bonusNumber);
    }

    private void rangeValidate(String bonusNumber){
        if(Integer.parseInt(bonusNumber)<1 || Integer.parseInt(bonusNumber)>45){
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }

    private void bonusNumberInWinningNumbers(List<Integer> winningNumbers , String bonusNumber){
        if(winningNumbers.contains(Integer.parseInt(bonusNumber))){
            throw new IllegalArgumentException(BONUS_NUMBER_IN_WINNING_NUMBER_ERROR_MSG);
        }
    }

    private void numberOfInputsValidate(String winningNumbers){
        if(winningNumbers.chars().filter(c -> c == CHAR_COMMA).count() != NUMBER_OF_COMMA){
            throw new IllegalArgumentException(CIPHER_ERROR_MSG);
        }
    }

    private void isNumberValidateWinningNumbers(String winningNumbers){
        String [] numbers = winningNumbers.split(STRING_COMMA);

        for(String number : numbers){
            try {
                Integer.parseInt(number);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException(NOT_NUMBER_ERROR_IN_WINNING_NUMBER_MSG);
            }
        }
    }

    private void duplicateValidate(String winningNumbers){
        String [] numbers = winningNumbers.split(STRING_COMMA);
        List<String> duplicateCheck = new ArrayList<>();

        for(String number : numbers){
            if(duplicateCheck.contains(number)){
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MSG);
            }
            duplicateCheck.add(number);
        }
    }

    private void rangeValidateWinninNumbers(String winningNumbers){
        String [] numbers = winningNumbers.split(STRING_COMMA);

        for(String number : numbers){
            if(Integer.parseInt(number)<1 || Integer.parseInt(number)>45){
                throw new IllegalArgumentException(RANGE_ERROR_MSG);
            }
        }
    }

    private void isNumberValidate(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MSG);
        }
    }

    private void minimumRangeValidate(String money){
        if (Integer.parseInt(money) < LOTTO_CHARGE) {
            throw new IllegalArgumentException(UNDER_THAN_LOTTO_CHARGE_ERROR_MSG);
        }
    }

    private void unitValidate(String money){
        if(Integer.parseInt(money) % LOTTO_CHARGE != 0){
            throw new IllegalArgumentException(UNIT_ERROR_MSG);
        }
    }
}
