package lotto;

import java.util.List;

public class LottoResult {
    private long payment = 0;
    private long totalPrize = 0;
    private final int[] numRanks = new int[6];

    public void add(LottoRank rank) {
        payment += 1000;
        totalPrize += rank.getPrize();
        numRanks[rank.getRank()]++;
    }

    public void total(List<LottoRank> ranks) {
        for (LottoRank rank : ranks) {
            add(rank);
        }
    }

    public double getYield() throws IllegalArgumentException {
        if (payment == 0) {
            throw new IllegalArgumentException("최소 한 번의 결과가 존재해야 합니다.");
        }
        return (double) totalPrize / payment * 100;
    }

    public int getNumOfRank(LottoRank rank) {
        return numRanks[rank.getRank()];
    }
}