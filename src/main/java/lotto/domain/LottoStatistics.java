package lotto.domain;

public class LottoStatistics {

    private int payment = 0;
    private int totalPrize = 0;
    private final int[] numRanks = new int[6];

    /**
     * 한 번의 로또 결과를 추가합니다.
     * @param rank 로또 결과
     */
    public void add(LottoRank rank) {
        payment += 1000;
        totalPrize += rank.getPrize();
        numRanks[rank.getRank()]++;
    }

    /**
     * 수익률을 반환합니다.
     * @return 수익률
     */
    public double getYield() {
        return (double) totalPrize / payment;
    }

    /**
     * 1 ~ 5등별 당첨 횟수를 반환합니다.
     * @param rank 0 ~ 5 범위의 숫자 (낙첨은 0)
     * @return 당첨 횟수
     */
    public int getNumOfRank(int rank) {
        if (rank < 0 || rank >= numRanks.length)
            throw new IllegalArgumentException();
        return numRanks[rank - 1];
    }
}
