package lotto.dto;

public class RankAggregationDto {

    private final int firstRankCount;
    private final int secondRankCount;
    private final int thirdRankCount;
    private final int fourthRankCount;
    private final int fifthRankCount;

    public RankAggregationDto(int firstRankCount, int secondRankCount, int thirdRankCount, int fourthRankCount, int fifthRankCount) {
        this.firstRankCount = firstRankCount;
        this.secondRankCount = secondRankCount;
        this.thirdRankCount = thirdRankCount;
        this.fourthRankCount = fourthRankCount;
        this.fifthRankCount = fifthRankCount;
    }

    public static RankAggregationDto of(int firstRankCount, int secondRankCount, int thirdRankCount, int fourthRankCount, int fifthRankCount) {
        return new RankAggregationDto(firstRankCount, secondRankCount, thirdRankCount, fourthRankCount, fifthRankCount);
    }

    public int getFirstRankCount() {
        return firstRankCount;
    }

    public int getSecondRankCount() {
        return secondRankCount;
    }

    public int getThirdRankCount() {
        return thirdRankCount;
    }

    public int getFourthRankCount() {
        return fourthRankCount;
    }

    public int getFifthRankCount() {
        return fifthRankCount;
    }
}
