package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Constants;
import lotto.domain.Lotto;
import lotto.domain.Statistics;
import lotto.domain.StatisticsMaker;

public class Output {

    public void printMoneyInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputMoneyResultMessage(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(Statistics statistics) {
        Map<Integer, Integer> ranking = statistics.getRanking();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ranking.get(Constants.FIFTH_RANK.getValue()) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranking.get(Constants.FOURTH_RANK.getValue()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranking.get(Constants.THIRD_RANK.getValue()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranking.get(Constants.SECOND_RANK.getValue()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranking.get(Constants.FIRST_RANK.getValue()) + "개");
        System.out.println("총 수익률은 " + statistics.getYield() + "%입니다.");

    }
}
