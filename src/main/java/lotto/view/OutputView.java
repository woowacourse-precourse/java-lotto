package lotto.view;

import java.text.DecimalFormat;
import java.util.Map.Entry;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.Ranking;
import lotto.model.WinningStatistics;

public class OutputView {

    public void printLottoTicketsAmount(Messages message, LottoTickets lottoTickets) {

        System.out.printf(message.getMessage(), lottoTickets.getTicketCounts());
        printLottoTicketsNumber(lottoTickets);
    }

    private void printLottoTicketsNumber(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printExceptionMessage(Exception e) {
        String errorMessage = e.getMessage();
        System.out.println(ErrorMessages.PREFIX.getErrorMessage() + errorMessage);
    }

    public void outputResult(WinningStatistics winningStatistics, Money budget) {
        System.out.println("\n당첨통계");
        System.out.println("---");

        for (Entry<Ranking, Long> entrySet : winningStatistics.rankBoard.entrySet()) {
            int rank = entrySet.getKey().getRank();
            long prize = entrySet.getKey().getPrize();
            Long value = entrySet.getValue();

            if (entrySet.getKey() == Ranking.DEFAULT) {
                break;
            }

            if (entrySet.getKey() == Ranking.SECOND) {

                System.out.printf(Messages.LOTTO_BONUS_RESULT.getMessage(), rank,
                    setLongNumberByComma(prize),
                    value);
                continue;
            }
            System.out.printf(Messages.LOTTO_RESULT.getMessage(), rank, setLongNumberByComma(prize),
                value);
        }

        double profit = 100 * (winningStatistics.getRewardSum() / (float) budget.getMoney());
        if (budget.getMoney() == 0) {
            profit = 0;
        }
        System.out.printf(Messages.LOTTO_PROFIT.getMessage(), setDoubleNumberByComma(profit));
    }

    public String setLongNumberByComma(long money) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(money);
    }

    public String setDoubleNumberByComma(double profit) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(Double.parseDouble(Double.toString(profit)));
    }
}
