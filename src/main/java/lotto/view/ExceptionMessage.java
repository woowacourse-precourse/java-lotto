package lotto.view;

public class ExceptionMessage {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_NUMBER_RANGE = "[ERROR] 숫자는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_OVERLAP = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String INPUT_TYPE_ERROR = "[ERROR] 숫자만 입력해 주세요.";
    private static final int LOTTO_MIN_AMOUNT = 1000;
    private static final String NOT_NUMBER_ERROR = "[ERROR] 금액은 숫자만 등록 가능합니다.";
    private static final String NOT_NATURAL_NUMBER_ERROR = "[ERROR] 금액은 0 초과이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER_ERROR = "[ERROR] 금액은 " + LOTTO_MIN_AMOUNT + "단위여야 합니다.";

    public static void rangeException() {
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void sizeException() {
        System.out.println(NOT_NUMBER_SIZE);
    }

    public static void overlapException() {
        System.out.println(NOT_NUMBER_OVERLAP);
    }

    public static void typeException() {
        System.out.println(INPUT_TYPE_ERROR);
    }

    public static void numberException() {
        System.out.println(NOT_NUMBER_ERROR);
    }

    public static void naturalException() {
        System.out.println(NOT_NATURAL_NUMBER_ERROR);
    }

    public static void divisibleException() {
        System.out.println(NOT_DIVISIBLE_NUMBER_ERROR);
    }

}
