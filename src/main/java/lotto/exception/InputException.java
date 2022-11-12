package lotto.exception;

public class InputException {
    private final static String NUMBER_REGEX = "[0-9]+";

    public static void validateIsNumber(String number) {
        if (!number.matches(NUMBER_REGEX)) {
            System.out.print("[ERROR] 숫자만 입력할 수 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
