package lotto;

public enum Result {
    FIFTH(5000,3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private final int prize;
    private final int standard;

    Result(int prize, int standard) {
        this.prize = prize;
        this.standard = standard;
    }

    public int getPrize() {
        return prize;
    }
    public int getStandard() {
        return standard;
    }
    public static Result findResultByStandard(int standard) {

        Result[] values = Result.values();
        for (Result result : values) {
            if (result.standard == standard) {
                return result;
            }
        }
        return null;
    }
}
