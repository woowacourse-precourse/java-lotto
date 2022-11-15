package lotto.domain;

public enum Rank {
    FIFTH(3, "3개 일치 (5,000원)"), FOURTH(4, "4개 일치 (50,000원)"), THIRD(5, "5개 일치 (1,500,000원)"), SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)"), FIRST(6, "6개 일치 (2,000,000,000원)");

    private final int value;
    private final String ouputMessage;
    private static final Rank[] RANK_DIR = Rank.values();

    Rank(int value, String ouputMessage) {
        this.value = value;
        this.ouputMessage = ouputMessage;
    }

    public int getValue() {
        return value;
    }

    public String ouputMessage() {
        return ouputMessage;
    }

    public static String of(int count) {
        for (Rank rank : RANK_DIR) {
            if (rank.getValue() == count) {
                return rank.name();
            }
        }
        return null;
    }
}
