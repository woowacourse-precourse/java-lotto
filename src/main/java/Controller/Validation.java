package Controller;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;


public class Validation {

    public static void validateMoneyInput(String money){
        validateInputIsNumeric(money);
        validateInputIsBiggerThanLottoPrice(money, Constant.LOTTO_PRICE);
        validateInputIsMultipleLottoPrice(money, Constant.LOTTO_PRICE);
    }

    public static void validateWinningNumberInput(String readWinningNumber){
        validateWinningNumbersHaveComma(readWinningNumber);
        validateWinningNumbersHaveBlank(readWinningNumber);
        validateWinningNumbersHaveNumbers(readWinningNumber);
        validateWinningNumbersAreInRange(readWinningNumber, Constant.LOTTO_NUMBER_RANGE_START, Constant.LOTTO_NUMBER_RANGE_END);
        validateWinningNumbersIsOverlapped(readWinningNumber);
    }

    public static void validateBonusNumberInput(String readBonusNumber, List<Integer> winningNumbers){
        validateInputIsNumeric(readBonusNumber);
        validateNumberIsInRange(readBonusNumber, Constant.LOTTO_NUMBER_RANGE_START, Constant.LOTTO_NUMBER_RANGE_END);
        validateNumberIsNotInWinningNumbers(readBonusNumber, winningNumbers);
    }

    public static void validateInputIsNumeric(String input){
        if(!Pattern.matches(Constant.REGEX_NUMERIC, input)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_NOT_NUMERIC);
        }
    }

    public static void validateInputIsBiggerThanLottoPrice(String input, int LOTTO_PRICE){
        int money = Integer.parseInt(input);
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_MONEY_IS_INSUFFICIENT);
        }
    }

    public static void validateInputIsMultipleLottoPrice(String input, int LOTTO_PRICE){
        int money = Integer.parseInt(input);
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_NOT_MULTIPLE_LOTTO_PRICE);
        }
    }

    public static void validateWinningNumbersHaveComma(String readWinningNumber){
        int commaCount = readWinningNumber.length() - readWinningNumber.replace(Constant.DELIMITER, "").length();
        if(commaCount != Constant.LOTTO_LENGTH - 1){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_DELIMITER_NUMBER_IS_INCORRECT);
        }
    }

    public static void validateWinningNumbersHaveBlank(String readWinningNumber){
        for(String s : readWinningNumber.split(Constant.DELIMITER)){
            if(s.isEmpty()){
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_BETWEEN_NUMBER_NOT_DELIMITER);
            }
        }
    }
    public static void validateWinningNumbersHaveNumbers(String readWinningNumber){
        for(String s : readWinningNumber.split(Constant.DELIMITER)){
            if(!Pattern.matches(Constant.REGEX_NUMERIC, s)){
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_BETWEEN_DELIMITER_NOT_NUMBER);
            }
        }
    }

    public static void validateWinningNumbersAreInRange(String readWinningNumber, int RANGE_START, int RANGE_END) {
        for (String s : readWinningNumber.split(Constant.DELIMITER)) {
            int number = Integer.parseInt(s);
            if (number < RANGE_START || number > RANGE_END) {
                throw new IllegalArgumentException(Constant.ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE);
            }
        }
    }

    public static void validateWinningNumbersIsOverlapped(String readWinningNumber){
        HashSet<Integer> hashSet = new HashSet<>();
        for(String s : readWinningNumber.split(Constant.DELIMITER)){
            hashSet.add(Integer.parseInt(s));
        }
        if(hashSet.size() != Constant.LOTTO_LENGTH){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_WINNING_NUMBER_IS_DUPLICATED);
        }
    }

    public static void validateNumberIsInRange(String readBonusNumber, int RANGE_START, int RANGE_END){
        int number = Integer.parseInt(readBonusNumber);
        if(number < RANGE_START || number > RANGE_END ){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE);
        }
    }

    public static void validateNumberIsNotInWinningNumbers(String readBonusNumber, List<Integer> winningNumbers){
        int bonusNumber = Integer.parseInt(readBonusNumber);
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_BONUS_IS_DUPLICATED);
        }
    }
}
