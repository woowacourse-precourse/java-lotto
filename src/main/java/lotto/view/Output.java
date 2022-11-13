package lotto.view;

import java.util.Map;
import lotto.domain.User;
import lotto.domain.WinningLotto;

public class Output {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String STASTISTICS_MESSAGE = "당첨 통계\n---";
    private static final String HYPEN = " - ";
    private static final String COUNT = "개";


    public static void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printPurchaseLottoMessage(int lottoCount) {
        System.out.println(lottoCount + PURCHASE_LOTTO_MESSAGE);
    }

    public static void printStatistic() {
        System.out.println(STASTISTICS_MESSAGE);
    }

    public static void printWinningLottoCount(Map<WinningLotto, Integer> winningLottoCount, WinningLotto winningLotto) {
        System.out.print(winningLotto.getName());
        System.out.print(HYPEN);
        System.out.print(winningLottoCount.get(winningLotto));
        System.out.println(COUNT);
    }

    public static void printWinningLotto(Map<WinningLotto, Integer> winningLottoCount) {
        for (WinningLotto winningLotto : winningLottoCount.keySet()) {
            if (winningLotto.equals(WinningLotto.NOTHING)) {
                continue;
            }
            printWinningLottoCount(winningLottoCount, winningLotto);
        }
    }

    public static void printProfit(float profit) {
        System.out.printf("총 수익률은 %.1f", profit);
        System.out.print("%입니다.");
    }


}
