package lotto.winstatistics;

import lotto.AllLottoMessage;
import lotto.calculate.CountNumberOfWins;
import lotto.calculate.RateOfReturn;
import lotto.lottocontroller.BuyLotto;
import lotto.winningnumbers.WinningNumbers;

public class Win {
    public void statisticsMessage() {
        System.out.println(AllLottoMessage.LINE_BREAK_CHARACTER.getMessage() + AllLottoMessage.WIN_STATISTICS.getMessage()
                + AllLottoMessage.TITLE_DISTINGUISHING_ROLE.getMessage());
    }

    private void printWinStatistics(CountNumberOfWins countNumberOfWins) {
        System.out.printf(AllLottoMessage.FIFTH_GRADE_STATISTICS.getMessage(), countNumberOfWins.getFifthPlace());
        System.out.printf(AllLottoMessage.FOURTH_GRADE_STATISTICS.getMessage(), countNumberOfWins.getFourthPlace());
        System.out.printf(AllLottoMessage.THIRD_GRADE_STATISTICS.getMessage(), countNumberOfWins.getThirdPlace());
        System.out.printf(AllLottoMessage.SECOND_GRADE_STATISTICS.getMessage(), countNumberOfWins.getSecondPlace());
        System.out.printf(AllLottoMessage.FIRST_GRADE_STATISTICS.getMessage(), countNumberOfWins.getFirstPlace());
    }

    private void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.printf(AllLottoMessage.RATE_OF_RETURNS.getMessage(), rateOfReturn.getRateOfReturn()
                , AllLottoMessage.PERCENT_CHARACTER.getMessage());
    }

    public void statistics() {
        BuyLotto buyLotto = new BuyLotto();
        WinningNumbers winningNumbers = new WinningNumbers();
        CountNumberOfWins countNumberOfWins = new CountNumberOfWins(buyLotto, winningNumbers);
        RateOfReturn rateOfReturn = new RateOfReturn(countNumberOfWins);

        countNumberOfWins.ranking();
        rateOfReturn.calculateSumOfPrize();
        statisticsMessage();
        printWinStatistics(countNumberOfWins);
        printRateOfReturn(rateOfReturn);
    }
}
