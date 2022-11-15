package lotto;

public enum LottoWinType {
    THREE("THREE", 3, false, 5_000, "3개 일치 (5,000원) - $THREE개"),
    FOUR("FOUR", 4, false, 50_000, "4개 일치 (50,000원) - $FOUR개"),
    FIVE("FIVE", 5, false, 1_500_000, "5개 일치 (1,500,000원) - $FIVE개"),
    FIVE_BONUS("FIVE_BONUS", 5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - $FIVE_BONUS개"),
    SIX("SIX", 6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - $SIX개");

    private final String key;
    private final int value;
    private final boolean winBonusNumber;
    private final float prizeMoney;
    private final String eventMessage;

    LottoWinType(
            String key,
            int value,
            boolean winBonusNumber,
            float prizeMoney,
            String eventMessage
    ) {
        this.key = key;
        this.value = value;
        this.winBonusNumber = winBonusNumber;
        this.prizeMoney = prizeMoney;
        this.eventMessage = eventMessage;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getWinBonusNumber() {
        return this.winBonusNumber;
    }

    public float getPrizeMoney() {
        return prizeMoney;
    }

    public String getEventMessage() {
        return this.eventMessage;
    }
}
