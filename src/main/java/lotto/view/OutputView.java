package lotto.view;

import lotto.Enum.Ranking;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_ENTER_MONEY = "구입금액을 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_SUCCESS = "개를 구매했습니다.";
    private static final String OUTPUT_ENTER_LOTTO_ANSWER = "당첨 번호를 입력해 주세요.";
    private static final String OUTPUT_ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_WINNING_RESULTS = "당첨 통계";
    private static final String OUTPUT_LINE = "---";


    private void outputPrint(String print) {
        System.out.println(print);
    }

    public static void outputEnterMoney() {
        System.out.println(OUTPUT_ENTER_MONEY);
    }

    public static void outputEnterLottoAnswer() {
        System.out.println(OUTPUT_ENTER_LOTTO_ANSWER);
    }

    public static void outputEnterBonusNumber() {
        System.out.println(OUTPUT_ENTER_BONUS_NUMBER);
    }

    public static void outputPurchaseSuccess(List<Lotto> userLottos) {
        System.out.println(userLottos.size() + OUTPUT_PURCHASE_SUCCESS);
        for(Lotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
    }

    public static void outputWinningResults(Map<Ranking, Integer> winningResults, double profitPercent) {
        System.out.println(OUTPUT_WINNING_RESULTS);
        System.out.println(OUTPUT_LINE);
        for (Ranking ranking : Ranking.values()) {
            System.out.println(ranking.description() + winningResults.get(ranking) + "개");
        }
        System.out.println("총 수익률은 " + profitPercent + "%입니다.");
    }
    //3개 일치 (5,000원) - 1개
    //4개 일치 (50,000원) - 0개
    //5개 일치 (1,500,000원) - 0개
    //5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    //6개 일치 (2,000,000,000원) - 0개
    //총 수익률은 62.5%입니다.
}
