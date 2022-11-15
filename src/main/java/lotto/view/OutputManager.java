package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoPile;

import java.util.List;

public class OutputManager {
    private static final String OUTPUT_MESSAGE_PURCHASE_AMOUNT = "개를 구매했습니다.";
    private static final String OUTPUT_MESSAGE_WINNING_STATISTIC = "당첨 통계\n---";
    private static final String OUTPUT_MESSAGE_WINNING_6 = "6개 일치 (2,000,000,000원) - ";
    private static final String OUTPUT_MESSAGE_WINNING_5 = "5개 일치 (1,500,000원) - ";
    private static final String OUTPUT_MESSAGE_WINNING_5_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String OUTPUT_MESSAGE_WINNING_4 = "4개 일치 (50,000원) - ";
    private static final String OUTPUT_MESSAGE_WINNING_3 = "3개 일치 (5,000원) - ";

    private static final String OUTPUT_MESSAGE_REVENUE = "총 수익률은 ";


    public OutputManager() {
    }

    public void printMessagePurchaseAmount(LottoPile lottoPile) {
        int lottoCount = lottoPile.getLottos().size();
        System.out.println(lottoCount + OUTPUT_MESSAGE_PURCHASE_AMOUNT);
    }

    public void printLottos(LottoPile lottoPile) {
        printMessagePurchaseAmount(lottoPile);

        List<Lotto> lottoList = lottoPile.getLottos();

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningResult(List<Integer> winningResult) {
        System.out.println(OUTPUT_MESSAGE_WINNING_STATISTIC);

        printThree(winningResult);
        printFour(winningResult);
        printFive(winningResult);
        printFiveAndBonus(winningResult);
        printSix(winningResult);
    }

    private void printSix(List<Integer> winningResult) {
        int six = winningResult.get(6);
        System.out.println(OUTPUT_MESSAGE_WINNING_6 + six + "개");
    }

    private void printFiveAndBonus(List<Integer> winningResult) {
        int fiveAndBonus = winningResult.get(0);
        System.out.println(OUTPUT_MESSAGE_WINNING_5_BONUS + fiveAndBonus + "개");
    }

    private void printFive(List<Integer> winningResult) {
        int five = winningResult.get(5);
        System.out.println(OUTPUT_MESSAGE_WINNING_5 + five + "개");
    }

    private void printFour(List<Integer> winningResult) {
        int four = winningResult.get(4);
        System.out.println(OUTPUT_MESSAGE_WINNING_4 + four + "개");
    }

    private void printThree(List<Integer> winningResult) {
        int three = winningResult.get(3);
        System.out.println(OUTPUT_MESSAGE_WINNING_3 + three + "개");
    }

    public void printRevenue(double revenue) {
        System.out.println(OUTPUT_MESSAGE_REVENUE + revenue + "%입니다.");
    }
}
