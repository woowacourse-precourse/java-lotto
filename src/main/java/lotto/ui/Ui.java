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
}
