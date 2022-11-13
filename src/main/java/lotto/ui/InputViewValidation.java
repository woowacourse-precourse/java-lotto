package lotto.ui;

import java.util.regex.Pattern;

public class InputViewValidation {

    static final String ERROR_NOT_INTEGER_FORMAT = "[ERROR] 숫자만 입력해주세요.";
    static final String ERROR_NOT_1000 = "[ERROR] 1000단위 숫자만 입력해주세요.";
    static final String ERROR_LOTTO_SIZE = "[ERROR] 6개의 당첨 번호를 입력해주세요.";
    static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");


    public static void validateIsInteger(String input) {
        if (!NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_FORMAT);
        }
    }

    public static void validateIs1000(String input) {
        if (input.charAt(input.length() - 1) != '0' || input.charAt(input.length() - 2) != '0' || input.charAt(input.length() - 3) != '0') {
            throw new IllegalArgumentException(ERROR_NOT_1000);
        }
    }

    public static void validateWinningNumbersSize(String input){
        String[] winningNumbers = input.split(",");
        if (winningNumbers.length != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    public static void validateWinningNumbersInteger(String input){
        String[] winningNumbers = input.split(",");
        for (String number: winningNumbers) {
            if (!NUMBER_PATTERN.matcher(number).find()){
                throw new IllegalArgumentException(ERROR_NOT_INTEGER_FORMAT);
            }
        }
    }

    public static void validateWinningNumbersRange(String input){
        String[] winningNumbers = input.split(",");
        for (String number: winningNumbers) {
            if (Integer.parseInt(number) > 45 && Integer.parseInt(number) < 1){
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }
}
