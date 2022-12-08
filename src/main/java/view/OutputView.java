package view;

import domain.Rank;
import domain.Result;
import domain.lotto.Lotto;
import domain.lotto.Lottos;
import domain.Money;
import java.util.List;

public class OutputView {

    private final int MONEY_UNIT = 1000;

    public void printHowManyLottery(Money money) {
        System.out.printf("%d개를 구매했습니다.%n", money.getMoney() / MONEY_UNIT);
    }

    public void printLotteriesNumbers(Lottos lottos) {
        for (int order = 0; order < lottos.size(); order++) {
            System.out.println(printEachLottoNumbers(lottos.get(order)));
        }
    }

    public void printResult(int[] winning, double earnRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%s(%,d원) - %d개\n", Rank.FIFTH.getValue(), Rank.FIFTH.getReward(), winning[0]);
        System.out.printf("%s(%,d원) - %d개\n", Rank.FOURTH.getValue(), Rank.FOURTH.getReward(), winning[1]);
        System.out.printf("%s(%,d원) - %d개\n", Rank.THIRD.getValue(), Rank.THIRD.getReward(), winning[2]);
        System.out.printf("%s(%,d원) - %d개\n", Rank.SECOND.getValue(), Rank.SECOND.getReward(), winning[3]);
        System.out.printf("%s(%,d원) - %d개\n", Rank.FIRST.getValue(), Rank.FIRST.getReward(), winning[4]);
        System.out.print("총 수익률은 " + String.format("%,.1f", earnRate) + "%입니다.");
    }

    private List<Integer> printEachLottoNumbers(Lotto lotto) {
        return lotto.printLotto();
    }
}
