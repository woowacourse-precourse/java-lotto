package lotto.util;

public class Validation {
    private static final String INPUT_NAN_ERROR_MSG = "[ERROR] 문자가 아닌 숫자를 입력해주세요.";
    private static final String INPUT_UNIT_ERROR_MSG = "[ERROR] 금액을 1000원 단위로 입력해주세요.";
    private static final String INPUT_LOTTO_NUMBER_RANGE_ERROR_MSG = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void validateMoney(String input) {
        if (isInteger(input)) {
            int money = Integer.parseInt(input);
            checkUnit(money);
        }
    }

    public static void validateLottoNumbers(String input) {
        String[] numbers = input.split(",");

        for (String s : numbers) {
            if (isInteger(s)) {
                int number = Integer.parseInt(s);
                checkInRange(number);
            }

        }
    }

    public static void validateBonusNumbers(String input) {
        if (isInteger(input)) {
            int number = Integer.parseInt(input);
            checkInRange(number);
        }
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NAN_ERROR_MSG);
        }

        return true;
    }

    private static void checkUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INPUT_UNIT_ERROR_MSG);
        }
    }

    private static void checkInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(INPUT_LOTTO_NUMBER_RANGE_ERROR_MSG);
        }
    }
}
