package lotto;

public class ResponseRankCombine {

    private final int firstCount;
    private final int secondCount;
    private final int thirdCount;
    private final int fourthCount;
    private final int fifthCount;

    public ResponseRankCombine(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.thirdCount = thirdCount;
        this.fourthCount = fourthCount;
        this.fifthCount = fifthCount;
    }

    public static ResponseRankCombine of(int firstCount, int secondCount, int thirdCount, int fourthCount, int fifthCount) {
        return new ResponseRankCombine(firstCount, secondCount, thirdCount, fourthCount, fifthCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Rank.FIFTH.getMatchCount()).append("개 일치 ").append("(").append(Rank.FIFTH.getWinningMoney()).append("원)").append(" - ").append(fifthCount).append("개");

        return sb.toString();
    }
}
