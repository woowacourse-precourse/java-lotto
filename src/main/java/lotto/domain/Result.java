package lotto.domain;

public enum Result {
    THREE_NUMBERS_MATCH(3, 5, "3개 일치 (5,000원) -"),
    FOUR_NUMBERS_MATCH(4, 4, "4개 일치 (50,000원) - "),
    FIVE_NUMBERS_MATCH(5, 3, "5개 일치 (1,500,000원) - "),
    FIVE_NUMBERS_AND_BONUS_NUMBER_MATCH(5, 2, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_NUMBERS_MATCH(6, 1, "6개 일치 (2,000,000,000원) - ");

    private static final String UNIT_MESSAGE = "개";
    private final int count;
    private final int rank;
    private final String message;

    Result(int count, int rank, String message) {
        this.count = count;
        this.rank = rank;
        this.message = message;
    }

    public static Result findResultByCount(int count) {
        for (Result result : Result.values()) {
            if (result.count == count) {
                return result;
            }
        }
        throw new RuntimeException();
    }

    public String getMessage() {
        return message;
    }

    public static String getUnitMessage() {
        return UNIT_MESSAGE;
    }
}
