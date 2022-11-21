package lotto;

import java.util.regex.Pattern;

public class InputService {

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    public void bonusValidate(String input, Lotto userLotto) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
        }
        int bonusNum = Integer.parseInt(input);
        for (Integer number:userLotto.getNumbers()) {
            if (number == bonusNum) {
                throw new IllegalArgumentException();
            }
        }
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ERROR.getMessage());
        }
    }

    public void moneyValidate(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException(ErrorMessage.MONEY_ERROR.getMessage());
        }
        int money = Integer.parseInt(input);
        if (money%1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_ERROR.getMessage());
        }
    }

    public void lottoInputValidate(String input) {
        String pattern = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_INPUT_ERROR.getMessage());
        }
    }
}
