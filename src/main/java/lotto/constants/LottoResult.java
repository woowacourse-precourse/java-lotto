package lotto.constants;

public enum LottoResult {
    THREE(3, 5_000, ""),
    FOUR(4, 50_000, ""),
    FIVE(5, 1_500_000, ""),
    BONUS(5, 30_000_000, ", 보너스 볼 일치"),
    SIX(6, 2_000_000_000, ""),
    NOPE(0, 0, "");
    private int prize;
    private int correctCount;
    private String message;

    LottoResult(int correctCount, int prize, String message) {
        this.prize = prize;
        this.correctCount = correctCount;
        this.message = message;
    }

    public static int getPrizeByCorrectCount(int correctCount) {
        LottoResult[] lottoResults = LottoResult.values();
        for (LottoResult l : lottoResults) {
            if (l.getCorrectCount() == correctCount) {
                return l.getPrize();
            }
        }
        return 0;
    }

    public static LottoResult hasCorrectCount(int correctCount) {
        LottoResult[] lottoResults = LottoResult.values();
        for (LottoResult l : lottoResults) {
            if (l.getCorrectCount() == correctCount) {
                return l;
            }
        }
        return NOPE;
    }

    public int getPrize() {
        return prize;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public String getMessage() {
        return message;
    }
}
