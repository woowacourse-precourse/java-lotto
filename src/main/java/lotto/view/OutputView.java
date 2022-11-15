package lotto.view;

import static lotto.constants.OutputConstant.OUTPUT_AMOUNT_OF_LOTTO;
import static lotto.constants.OutputConstant.OUTPUT_RATE_OF_PROFIT;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + OUTPUT_AMOUNT_OF_LOTTO);
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }

    public void printWinningHistory(LottoResult lottoResult) {
        Map<LottoRank, Integer> resultMap = lottoResult.get();
        for (LottoRank lottoRank : resultMap.keySet()) {
            if (lottoRank == LottoRank.LOSE) {
                continue;
            }
            System.out.println(lottoRank.getDescription() + " - " + resultMap.get(lottoRank) + "개");
        }
    }

    public void printRateOfProfit(double rateOfProfit) {
        System.out.println(String.format(OUTPUT_RATE_OF_PROFIT, rateOfProfit));
    }

}
