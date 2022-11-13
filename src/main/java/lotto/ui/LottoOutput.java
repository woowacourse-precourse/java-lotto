package lotto.ui;

import lotto.domain.LottoRank;
import java.util.List;

public class LottoOutput {
    public void printUserLotto(List<List<Integer>> userLotto) {
        StringBuilder sb = new StringBuilder();

        int amount = userLotto.size();

        sb.append(amount)
                .append(Messages.OUTPUT_USER_LOTTO.getMessage())
                .append("\n");

        for(List<Integer> lotto : userLotto) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }

    public void printLottoResult(List<LottoRank> lottoResult, String profitPercent) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.OUTPUT_LOTTO_RESULT.getMessage());

        for(LottoRank rank : LottoRank.values()) {
            int count = countRank(rank, lottoResult);

            if(rank != LottoRank.BLANK) {
                sb.append(rank.getMessage())
                        .append(count);
            }
        }

        System.out.println(sb);
    }

    public int countRank(LottoRank rank, List<LottoRank> lottoRanks) {
        long count = lottoRanks.stream()
                .filter(lottoRank -> lottoRank == rank)
                .count();
    }
}
