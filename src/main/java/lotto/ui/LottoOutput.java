package lotto.ui;

import lotto.domain.LottoRank;
import lotto.domain.LottoService;
import lotto.domain.UserLotto;

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

    public static void main(String[] args) {
        LottoOutput output = new LottoOutput();
        List<LottoRank> lottoRanks = List.of(LottoRank.FIFTH, LottoRank.BLANK, LottoRank.FIRST);

        output.printLottoResult(lottoRanks, "45");
    }
}
