package lotto.ui;

import lotto.domain.LottoRank;

import java.util.List;

public class LottoOutput {
    public void printUserLotto(List<List<Integer>> userLotto) {
        StringBuilder sb = new StringBuilder();

        int amount = userLotto.size();

        sb.append(amount)
                .append(Messages.LOTTO_AMOUNT.getMessage())
                .append("\n");

        for(List<Integer> lotto : userLotto) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }

    public void printLottoResult(List<LottoRank> lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.LOTTO_RESULT.getMessage());

        for(LottoRank rank : LottoRank.values()) {
            sb.append(createLottoResultMessage(rank, lottoResult));
        }

        System.out.println(sb);
    }

    public String createLottoResultMessage(LottoRank rank, List<LottoRank> lottoResult) {
        StringBuilder sb = new StringBuilder();

        long count = countRank(rank, lottoResult);

        if(rank != LottoRank.BLANK) {
            sb.append(rank.getMessage())
                    .append(count)
                    .append("\n");
        }
        return sb.toString();
    }

    public long countRank(LottoRank rank, List<LottoRank> lottoRanks) {
        long count = lottoRanks.stream()
                .filter(lottoRank -> lottoRank == rank)
                .count();

        return count;
    }

}
