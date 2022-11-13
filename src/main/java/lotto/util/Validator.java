package lotto.util;

import lotto.constant.Constant;

import java.util.List;

public class Validator {

    public static boolean hasNotCharacter(String numbers){

        final String REGEX = "[0-9]+";
        if (!numbers.matches(REGEX)){
            return false;
        }

        return true;
    }

    public static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isLottoMoney(int money){
        return money % Constant.LOTTO_PRICE == 0;
    }

    public static boolean isNotComma(String inputWinningNumbers) {

        String[] splitInputWinningNumbers = inputWinningNumbers.split(",");
        if (splitInputWinningNumbers.length != Constant.LOTTO_SIZE){
            return true;
        }

        return false;
    }

    public static boolean isListhasCharacter(List<String> inputNumbersList) {

        for(int i=0; i<inputNumbersList.size(); i++){
            if (!hasNotCharacter(inputNumbersList.get(i))){
                return true;
            }
        }

        return false;
    }
}
