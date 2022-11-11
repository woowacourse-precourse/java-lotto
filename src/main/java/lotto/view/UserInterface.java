package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.WinLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {
    String purchaseLotto() {
        System.out.println("구입금액을 입력하세요.");
        return Console.readLine();
    }

    void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매하였습니다.");
        lottos.forEach(System.out::println);
    }

    WinLotto winningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningLottoNum = Console.readLine();
        List<Integer> winningLottoNums = (List<Integer>) Arrays.stream(winningLottoNum.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(winningLottoNums);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();

    }

    void printRank() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    void printEarningRate() {
        System.out.println("총 수익률은 %.3f 입니다.");
    }

}
