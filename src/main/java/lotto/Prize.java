package lotto;

public enum Prize {
    THREE("3개 일치 (5,000원) - ", 5000),
    FOUR("4개 일치 (50,000원) - ", 50000),
    FIVE_NO_BONUS("5개 일치 (1,500,000원) - ", 1500000),
    FIVE_PLUS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIX("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String prizeMessage;
    public static final int FIND = 0;
    private final int prizeValue;

    Prize(String prizeMessage, int prizeValue) {
        this.prizeMessage = prizeMessage;
        this.prizeValue = prizeValue;
    }

    public static String getPrizeMessage(int matchCount) {
        for (Prize prize : Prize.values()) {
            matchCount--;
            if (matchCount == FIND) {
                return prize.prizeMessage;
            }
        }
        return "";
    }

    public static int getPrizeValue(int matchCount, int matchSize) {
        for (Prize prize : Prize.values()) {
            if (prize.prizeMessage.contains(matchCount + "개")) {
                return prize.prizeValue * matchSize;
            }
        }
        return 0;
    }
}
