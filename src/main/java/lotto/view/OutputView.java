package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.Statistics;

public class OutputView {

    public static void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInputMoneyResultMessage(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningStatistics(Statistics statistics) {
        Map<Integer, Integer> ranking = statistics.getRanking();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ranking.get(LottoConstants.FIFTH_RANK.getValue()) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranking.get(LottoConstants.FOURTH_RANK.getValue()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking.get(LottoConstants.THIRD_RANK.getValue()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranking.get(LottoConstants.SECOND_RANK.getValue()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking.get(LottoConstants.FIRST_RANK.getValue()) + "개");
        System.out.println("총 수익률은 " + statistics.getYield() + "%입니다.");

    }
}
