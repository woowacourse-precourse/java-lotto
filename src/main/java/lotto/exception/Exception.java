package lotto.exception;

public class Exception {
    private static final char INPUT_START = '0';
    private static final char INPUT_END = '9';
    public static final String ERROR = "[ERROR]";

    public static void validateIsNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            checkInterval(input.charAt(i), INPUT_START, INPUT_END);
        }
    }

    private static void checkInterval(char input, char startNumber, char endNumber) {
        if (input < startNumber || input > endNumber) {
            throw new IllegalArgumentException(ERROR + "숫자만 입력해주세요.");
        }
    }

    public static void validateIsThousandUnit(String input){
        if (Integer.parseInt(input)%1000 != 0) {
            throw new IllegalArgumentException(ERROR + "천 단위로 입력해주세요.");
        }
    }
}
