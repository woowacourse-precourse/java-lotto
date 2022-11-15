package lotto.view;

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
        System.out.println("3개 일치 (" + FIFTH.getPrize() + "원) -  " + winningLog[FIFTH.getWinningLogIdx()] + "개");
        System.out.println("4개 일치 (" + FOURTH.getPrize() + "원) -  " + winningLog[FOURTH.getWinningLogIdx()] + "개");
        System.out.println("5개 일치 (" + THIRD.getPrize() + "원) -  " + winningLog[THIRD.getWinningLogIdx()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + SECOND.getPrize() + "원) -  " + winningLog[SECOND.getWinningLogIdx()] + "개");
        System.out.println("6개 일치 (" + FIRST.getPrize() + "원) -  " + winningLog[FIRST.getWinningLogIdx()] + "개");
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
