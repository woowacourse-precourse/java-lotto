package lotto;

import java.util.List;

public class LottoStatistics {

    private long payment = 0;
    private long totalPrize = 0;
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
     * 수익률 (%)을 반환합니다.
     * @return 수익률
     * @throws IllegalArgumentException 수익률을 계산할 로또 구입내역이 존재하지 않을 때 발생합니다.
     */
    public double getYield() throws IllegalArgumentException {
        if (payment == 0) {
            throw new IllegalArgumentException("최소 한 번의 결과가 존재해야 합니다.");
        }
        return (double) totalPrize / payment * 100;
    }

    /**
     * 1 ~ 5등별 당첨 횟수를 반환합니다.
     * 0은 낙첨을 의미합니다.
     * @param rank 얻고 싶은 등수
     * @return 당첨 횟수
     */
    public int getNumOfRank(LottoRank rank) {
        return numRanks[rank.getRank()];
    }
}
