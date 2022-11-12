package lotto.domain;

import java.util.List;

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
     * 여러 번의 로또 결과를 추가합니다.
     * @param ranks 로또 결과 목록
     */
    public void addAll(List<LottoRank> ranks) {
        for (LottoRank rank : ranks) {
            add(rank);
        }
    }

    /**
     * 수익률을 반환합니다.
     * @return 수익률
     */
    public double getYield() {
        if (payment == 0) {
            throw new IllegalArgumentException("최소 한 번의 결과가 존재해야 합니다.");
        }
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
