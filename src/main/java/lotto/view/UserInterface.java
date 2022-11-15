package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utill.Lotto;
import lotto.utill.YieldResult;

import java.util.List;


public class UserInterface {
    public static String purchaseLotto() {
        System.out.println("구입금액을 입력하세요.");
        return Console.readLine();
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(System.out::println);
    }

    public static String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public static String inputWinningBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public static void printWinningResult(YieldResult lottoResult, int cost) {
        int reward = lottoResult.calcReward();
        double yield = Math.round((float) reward / cost * 1000) / 10.0;
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(lottoResult.getResult());
        System.out.println("총 수익률은 "+ yield + "%입니다.");
    }
}
