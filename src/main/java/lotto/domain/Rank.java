package lotto.domain;

public enum Rank {
    FIFTH(3,false,5_000, "3개 일치 (5,000원) - %d개"),
    FOURTH(4,false,50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5,false,1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5,true,30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6,false,2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int prize;
    private final String sentence;

    private final int SECOND_AND_THIRD_MATCH_COUNT = 5;

    Rank(int matchCount, boolean hasBonusNumber, int prize, String sentence) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
        this.sentence = sentence;
    }

    public int getPrize() {
        return this.prize;
    }

    public boolean hasSameRankBy(int matchCount, boolean hasBonusNumber) {
        if(matchCount == SECOND_AND_THIRD_MATCH_COUNT) {
            return this.hasBonusNumber == hasBonusNumber;
        }
        return this.matchCount == matchCount ;
    }

    public String getSentence() {
        return this.sentence;
    }

}
