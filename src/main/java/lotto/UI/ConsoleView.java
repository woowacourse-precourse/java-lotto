package lotto.UI;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.PrizeRank;

public class ConsoleView {
    public void printRequestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.get());
        }
    }

    public void printRequestWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요");
    }

    public void printRequestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printTotalPrize(Map<String, Integer> totalPrize) {
        System.out.println("\n당첨 통계");
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
