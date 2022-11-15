package lotto.view;

import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void inputWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void purchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public void printRanksResult(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            printRankResult(result, rank);
        }
    }

    private void printRankResult(Map<Rank, Integer> result, Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getMatch(), rank.getStrReward(), result.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n",
                rank.getMatch(), rank.getStrReward(), result.get(rank));
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void winningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
