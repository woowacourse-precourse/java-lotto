package lotto;

public enum LottoMatch {
    THREE(0, "3개 일치", 5000), FOUR(1, "4개 일치", 50_000),
    FIVE(2,"5개 일치", 1_500_000), FIVE_BONUS(3,"5개 일치, 보너스 볼 일치", 30_000_000),
    SIX(4,"6개 일치", 2_000_000_000);

    private int idx;
    private String name;
    private int value;

    LottoMatch(int idx, String name, int value) {
        this.idx = idx;
        this.name = name;
        this.value = value;
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public long getValue() {
        return value;
    }
}
