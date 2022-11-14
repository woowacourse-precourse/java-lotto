package lotto.ui;

import lotto.domain.LottoRank;

import java.util.List;

public class LottoOutput {
    public void printUserLotto(List<List<Integer>> userLotto) {
        StringBuilder sb = new StringBuilder();

        int amount = userLotto.size();

        sb.append("\n" + amount)
                .append(Messages.LOTTO_AMOUNT.getMessage())
                .append("\n");

        for (List<Integer> lotto : userLotto) {
            sb.append(lotto).append("\n");
        }

        System.out.println(sb);
    }

    public void printLottoResult(List<LottoRank> lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.LOTTO_RESULT.getMessage());

        for (LottoRank rank : LottoRank.values()) {
            sb.append(createLottoResultMessage(rank, lottoResult))
                    .append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public String createLottoResultMessage(LottoRank rank, List<LottoRank> lottoResult) {
        StringBuilder sb = new StringBuilder();

        long count = countRank(rank, lottoResult);

        if (rank != LottoRank.BLANK) {
            sb.append(rank.getMessage())
                    .append(count)
                    .append("개");
        }

        return sb.toString();
    }

    public long countRank(LottoRank rank, List<LottoRank> lottoRanks) {
        long count = lottoRanks.stream()
                .filter(lottoRank -> lottoRank == rank)
                .count();

        return count;
    }

    public void printProfitPercent(String percent) {
        StringBuilder sb = new StringBuilder();
        sb.append(Messages.LOTTO_PERCENT_HEAD.getMessage())
                .append(percent)
                .append(Messages.LOTTO_PERCENT_TAIL.getMessage());

        System.out.println(sb);
    }
}
