package Controller;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    static final int LOTTO_PRICE = 1000;
    static final int LOTTO_LENGTH = 6;
    static final int LOTTO_NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_RANGE_END = 45;
    static final String REGEX_NUMERIC = "^[0-9]*$";
    static final String DELIMITER = ",";
    static final String ERROR_MESSAGE = "[ERROR]";

    static final String ERROR_MESSAGE_NOT_NUMERIC = ERROR_MESSAGE + " 숫자로 이루어진 입력이 아닙니다.";
    static final String ERROR_MESSAGE_MONEY_IS_INSUFFICIENT = ERROR_MESSAGE + " 입력이 로또 가격(" + LOTTO_PRICE + "원)보디 낮은 숫자입니다.";
    static final String ERROR_MESSAGE_NOT_MULTIPLE_LOTTO_PRICE = ERROR_MESSAGE + " 입력이 로또 가격(" + LOTTO_PRICE + "원)의 배수인 숫자가 아닙니다."
    static final String ERROR_MESSAGE_DELIMITER_NUMBER_IS_INCORRECT = ERROR_MESSAGE + " 구분자(" + DELIMITER + ")의 개수가 입력 조건에 맞지 않습니다.";
    static final String ERROR_MESSAGE_BETWEEN_NUMBER_NOT_DELIMITER = ERROR_MESSAGE + " 당첨 번호 입력에서 구분자(" + DELIMITER + ")의 위치가 입력 조건에 맞지 않습니다. 콤마(,)는 숫자 사이에 존재해야 합니다.";
    static final String ERROR_MESSAGE_BETWEEN_DELIMITER_NOT_NUMBER = ERROR_MESSAGE + " 당첨 번호 입력에서 구분자(" + DELIMITER + ")사이에 데이터가 숫자로 이루어진 데이터가 아닙니다.";
    static final String ERROR_MESSAGE_WINNING_NUMBER_IS_DUPLICATED = ERROR_MESSAGE + " 당첨 번호 중에서 중복된 숫자가 존재합니다.";
    static final String ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE = ERROR_MESSAGE + " 입력이 " + LOTTO_NUMBER_RANGE_START + "~" + LOTTO_NUMBER_RANGE_END + " 범위 내의 숫자가 아닙니다.";
    static final String ERROR_MESSAGE_BONUS_IS_DUPLICATED = ERROR_MESSAGE + " 입력한 보너스 번호는 당첨 번호와 중복된 값입니다.";


    public static void validateMoneyInput(String money){
        validateInputIsNumeric(money);
        validateInputIsBiggerThanLottoPrice(money, LOTTO_PRICE);
        validateInputIsMultipleLottoPrice(money, LOTTO_PRICE);
    }

    public static void validateWinningNumberInput(String readWinningNumber){
        //
        //validateInputLength(readWinningNumber, LOTTO_LENGTH * 2 - 1);
        validateWinningNumbersHaveComma(readWinningNumber);
        validateWinningNumbersHaveBlank(readWinningNumber);
        validateWinningNumbersHaveNumbers(readWinningNumber);
        validateWinningNumbersAreInRange(readWinningNumber, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END);
        validateWinningNumbersIsOverlapped(readWinningNumber);
    }

    public static void validateBonusNumberInput(String readBonusNumber, List<Integer> winningNumbers){
        validateInputIsNumeric(readBonusNumber);
        validateNumberIsInRange(readBonusNumber, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END);
        validateNumberIsNotInWinningNumbers(readBonusNumber, winningNumbers);
    }

    public static void validateInputIsNumeric(String input){
        if(!Pattern.matches(REGEX_NUMERIC, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_NUMERIC);
        }
    }

    public static void validateInputIsBiggerThanLottoPrice(String input, int LOTTO_PRICE){
        int money = Integer.parseInt(input);
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_IS_INSUFFICIENT);
        }
    }

    public static void validateInputIsMultipleLottoPrice(String input, int LOTTO_PRICE){
        int money = Integer.parseInt(input);
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_MULTIPLE_LOTTO_PRICE);
        }
    }

    public static void validateWinningNumbersHaveComma(String readWinningNumber){
        int commaCount = readWinningNumber.length() - readWinningNumber.replace(DELIMITER, "").length();
        if(commaCount != LOTTO_LENGTH - 1){
            throw new IllegalArgumentException(ERROR_MESSAGE_DELIMITER_NUMBER_IS_INCORRECT);
        }
    }

    public static void validateWinningNumbersHaveBlank(String readWinningNumber){
        for(String s : readWinningNumber.split(DELIMITER)){
            if(s.isEmpty()){
                throw new IllegalArgumentException(ERROR_MESSAGE_BETWEEN_NUMBER_NOT_DELIMITER);
            }
        }
    }
    public static void validateWinningNumbersHaveNumbers(String readWinningNumber){
        for(String s : readWinningNumber.split(DELIMITER)){
            if(!Pattern.matches(REGEX_NUMERIC, s)){
                throw new IllegalArgumentException(ERROR_MESSAGE_BETWEEN_DELIMITER_NOT_NUMBER);
            }
        }
    }

    public static void validateWinningNumbersAreInRange(String readWinningNumber, int RANGE_START, int RANGE_END) {
        for (String s : readWinningNumber.split(DELIMITER)) {
            int number = Integer.parseInt(s);
            if (number < RANGE_START || number > RANGE_END) {
                throw new IllegalArgumentException(ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE);
            }
        }
    }

    public static void validateWinningNumbersIsOverlapped(String readWinningNumber){
        HashSet<Integer> hashSet = new HashSet<>();
        for(String s : readWinningNumber.split(DELIMITER)){
            hashSet.add(Integer.parseInt(s));
        }
        if(hashSet.size() != LOTTO_LENGTH){
            throw new IllegalArgumentException(ERROR_MESSAGE_WINNING_NUMBER_IS_DUPLICATED);
        }
    }

    public static void validateNumberIsInRange(String readBonusNumber, int RANGE_START, int RANGE_END){
        int number = Integer.parseInt(readBonusNumber);
        if(number < RANGE_START || number > RANGE_END ){
            throw new IllegalArgumentException(ERROR_MESSAGE_NUM_IS_OUT_OF_RANGE);
        }
    }

    public static void validateNumberIsNotInWinningNumbers(String readBonusNumber, List<Integer> winningNumbers){
        int bonusNumber = Integer.parseInt(readBonusNumber);
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_IS_DUPLICATED);
        }
    }
}
