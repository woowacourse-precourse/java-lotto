package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.reward.Reward;

public class Ui {
    public String inputBalance() {
        System.out.println("구입 금액을 입력해 주세요.");
        String in = Console.readLine();

        return in;
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public String inputMatchNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String in = Console.readLine();

        return in;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String in = Console.readLine();

        return in;
    }

    public void printInfo(int[] result) {
        Reward[] rewards = Reward.values();
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s - %d개\n", rewards[i].getRewardName(), result[i]);
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", profitRate * 100);
    }
}
