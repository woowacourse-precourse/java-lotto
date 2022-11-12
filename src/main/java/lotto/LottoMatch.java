package lotto;

public enum LottoMatch {
    THREE("3개 일치", 5000), FOUR("4개 일치", 50_000),
    FIVE("5개 일치", 1_500_000), FIVE_BONUS("5개 일치, 보너스 볼 일치", 30_000_000), SIX("6개 일치", 2_000_000_000);

    private String name;
    private long value;

    LottoMatch(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }
}
