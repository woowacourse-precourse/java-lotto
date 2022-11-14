package lotto;

public class ErrorMessages {
    private static final String prefix = "[ERROR] ";
    private static final String isNotNumber = "은(는) 숫자여야 합니다.";
    private static final String isUnableMoney = "은(는) 1000의 배수여야 합니다.";
    private static final String isOutOfBounds = "은(는) 1부터 45 사이의 숫자여야 합니다.";
    private static final String isNotMatch = "은(는) 6개여야 합니다.";
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
