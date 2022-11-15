package lotto.domain;

public enum LottoResult {
    first(2000000000),
    second(30000000),
    third(1500000),
    fourth(50000),
    fifth(5000),
    none(0);

    private int prizeMoney;

    LottoResult(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
