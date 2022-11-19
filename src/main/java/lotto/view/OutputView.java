package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.domain.Rank.*;
import static lotto.view.GuideMessage.*;

public class OutputView {
    public void printPurchasePriceMessage() {
        System.out.println(INPUT_PURCHASE_PRICE.getMessage());
    }

    public void printWinningNumbers(List<Integer> winningNumbers) {
        System.out.println(winningNumbers);
    }

    public void printPredictionNumbersMessage() {
        System.out.println(INPUT_PREDICTION_NUMBERS.getMessage());
    }

    public void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
    }

    public void printAmountOfLottoMessage(int amountOfLotto) {
        System.out.println("\n" + amountOfLotto + "개를 구매했습니다.");
    }

    public void printWinningLog(int[] winningLog) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        printWinningLogForRanks(FIFTH.getPredictionMatchCnt(), FIFTH.getPrize(), winningLog[FIFTH.getWinningLogIdx()]);
        printWinningLogForRanks(FOURTH.getPredictionMatchCnt(), FOURTH.getPrize(), winningLog[FOURTH.getWinningLogIdx()]);
        printWinningLogForRanks(THIRD.getPredictionMatchCnt(), THIRD.getPrize(), winningLog[THIRD.getWinningLogIdx()]);
        printWinningLogForSecondRank(SECOND.getPredictionMatchCnt(), SECOND.getPrize(), winningLog[SECOND.getWinningLogIdx()]);
        printWinningLogForRanks(FIRST.getPredictionMatchCnt(), FIRST.getPrize(), winningLog[FIRST.getWinningLogIdx()]);
    }

    public void printWinningLogForRanks(int predictionMatchCnt, int prize, int counts) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        String message = "%d개 일치 (%s원) - %d개\n";
        System.out.printf(message, predictionMatchCnt, formatter.format(prize), counts);
    }

    public void printWinningLogForSecondRank(int predictionMatchCnt, int prize, int counts) {
        DecimalFormat formatter = new DecimalFormat("###,###");

        String message = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
        System.out.printf(message, predictionMatchCnt, formatter.format(prize), counts);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
