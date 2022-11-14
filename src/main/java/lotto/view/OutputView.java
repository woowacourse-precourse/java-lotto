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
    private static final String OUTPUT_EA = "개";
    private static final String OUTPUT_PROFIT_PERCENT_IS_1 = "총 수익률은 ";
    private static final String OUTPUT_PROFIT_PERCENT_IS_2 = "%입니다.";

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
            System.out.println(ranking.description() + winningResults.get(ranking) + OUTPUT_EA);
        }
        System.out.println(OUTPUT_PROFIT_PERCENT_IS_1 + profitPercent + OUTPUT_PROFIT_PERCENT_IS_2);
    }

}
