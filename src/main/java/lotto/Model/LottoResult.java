package lotto.Model;

public enum LottoResult {
    THREE_WINS(3, 5_000, "3개 일치 (5,000원)"),
    FOUR_WINS(4, 50_000, "4개 일치 (50,000원)"),
    FIVE_WINS(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SIX_WINS(6, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIVE_AND_BONUS_WINS(7, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private int value;
    private int prize;
    private String message;

    LottoResult(int value, int prize, String message) {
        this.value = value;
        this.prize = prize;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
