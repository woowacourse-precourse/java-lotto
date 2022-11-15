package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;

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
        System.out.printf("3개 일치 (5,000원) - %d개\n", result[0]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", result[1]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result[3]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result[4]);
    }
}
