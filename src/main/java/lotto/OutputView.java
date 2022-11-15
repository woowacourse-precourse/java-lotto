package lotto;

import lotto.enums.OutputMessage;
import lotto.enums.RankPrize;

import java.util.Map;

public class OutputView {

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketsQuantity() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public void printWinningStatistics(Map<Integer, Integer> countRank) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.print(OutputMessage.WINNING_STATITSTICS_FIFTH_PRIZE.getMessage());
        System.out.println(countRank.get(RankPrize.FIFTH_PRIZE.getRank()) + OutputMessage.EA.getMessage());

        System.out.print(OutputMessage.WINNING_STATITSTICS_FOURTH_PRIZE.getMessage());
        System.out.println(countRank.get(RankPrize.FOURTH_PRIZE.getRank()) + OutputMessage.EA.getMessage());

        System.out.print(OutputMessage.WINNING_STATITSTICS_THIRD_PRIZE.getMessage());
        System.out.println(countRank.get(RankPrize.THIRD_PRIZE.getRank()) + OutputMessage.EA.getMessage());

        System.out.print(OutputMessage.WINNING_STATITSTICS_SECOND_PRIZE.getMessage());
        System.out.println(countRank.get(RankPrize.SECOND_PRIZE.getRank()) + OutputMessage.EA.getMessage());

        System.out.print(OutputMessage.WINNING_STATITSTICS_FIRST_PRIZE.getMessage());
        System.out.println(countRank.get(RankPrize.FIRST_PRIZE.getRank()) + OutputMessage.EA.getMessage());
    }

    public void printTotalProfitRate(ProfitRate profitRate) {
        System.out.print(OutputMessage.PROFIT_RATE_PREFIX_MESSAGE.getMessage());
        System.out.print(String.format("%.1f", profitRate.getTotalProfitRate()));
        System.out.println(OutputMessage.PROFIT_RATE_SUFIX_MESSAGE.getMessage());
    }


}
