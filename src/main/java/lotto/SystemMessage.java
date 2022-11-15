package lotto;

import java.text.NumberFormat;
import java.util.Map;

public class SystemMessage {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public static void purchaseLotto(int lottoTickets, Lottos lottos) {
        System.out.println();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void winningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static String putComma(int number) {
        return NumberFormat.getInstance().format(number);
    }

    public static void winningResult(Map<Ranking, Integer> winningResult) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        for (Ranking lottoOperator : winningResult.keySet()) {
            if (lottoOperator == Ranking.NOTHING) {
                continue;
            }
            if (lottoOperator == Ranking.SECOND) {
                printBonusResult(winningResult, lottoOperator);
                continue;
            }
            printCommonResult(winningResult, lottoOperator);
        }
    }

    private static void printBonusResult(Map<Ranking, Integer> winningResult, Ranking rank) {
        System.out.println(
                rank.getCount() + "개 일치, 보너스 볼 일치 (" +
                        putComma(rank.getPrize()) + "원) - " +
                        winningResult.get(rank) + "개");
    }

    private static void printCommonResult(Map<Ranking, Integer> winningResult, Ranking rank) {
        System.out.println(rank.getCount() + "개 일치 (" +
                        putComma(rank.getPrize()) + "원) - " +
                        winningResult.get(rank) + "개");
    }

    public static void profit(double profit) {
        String formattedProfit = String.format("%,.1f", profit);
        System.out.println("총 수익률은 " + formattedProfit + "%입니다.");
    }
}
