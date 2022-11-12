package lotto.entity;

public enum Place {

    FIFTH(5_000, 3, "3개 일치 "),
    FOURTH(50_000, 4, "4개 일치 "),
    THIRD(1_500_000, 5, "5개 일치 "),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 "),
    FIRST(2_000_000_000, 6, "6개 일치 ");

    private final int prizeMoney;
    private final int matchingNumber;
    private final String words; //ui?

    private Place(int prizeMoney, int matchingNumber, String words) {
        this.prizeMoney = prizeMoney;
        this.matchingNumber = matchingNumber;
        this.words = words;
    }


    public long getPrizeMoney() {
        return this.prizeMoney;
    }

    public int getMatchingNumber() {
        return this.matchingNumber;
    }

    public String getWords() {
        return this.words;
    }
}
