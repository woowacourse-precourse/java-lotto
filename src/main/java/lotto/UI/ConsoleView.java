package lotto.UI;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;

public class ConsoleView {
    public void printRequestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int money) {
        System.out.println();
        System.out.println(money / 1000 + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.get());
        }
    }

    public void printRequestWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printTotalPrize(Map<String, Integer> totalPrize) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (PrizeRank value : PrizeRank.values()) {
            System.out.print(value.getDescription());
            System.out.println(totalPrize.get(value.name()) + "개");
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
