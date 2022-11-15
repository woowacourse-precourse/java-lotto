package lotto;

public class ErrorMessage extends UniqueFile {
    private static final String prefix = "[ERROR] ";
    private static final String isNotNumber = "은(는) 숫자여야 합니다.";
    private static final String isUnableMoney = String.format("은(는) %d의 배수여야 합니다.", PRICE);
    private static final String isOutOfBounds = String.format("은(는) %d부터 %d 사이의 숫자여야 합니다.", MIN, MAX);
    private static final String isNotMatch = String.format("은(는) %d개여야 합니다.", MAX_COUNT);
    private static final String isRepeated = "은(는) 중복될 수 없습니다.";

    public static String isNotNumber(String type) {
        return prefix + type + isNotNumber;
    }

    public static String isUnableMoney(String type) {
        return prefix + type + isUnableMoney;
    }

    public static String isOutOfBounds(String type) {
        return prefix + type + isOutOfBounds;
    }

    public static String isNotMatch(String type) {
        return prefix + type + isNotMatch;
    }

    public static String isRepeated(String type) {
        return prefix + type + isRepeated;
    }
}
