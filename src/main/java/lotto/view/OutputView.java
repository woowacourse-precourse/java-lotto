package lotto.view;

import lotto.model.Lotto;
import lotto.model.Result;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printLottos(List<Lotto> lottos, int amount) {
        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(Map<Result, Integer> resultMap) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Result result : Result.values()) {
            if (result != Result.NO_REWARD) {
                System.out.println(result.getMessage() + resultMap.get(result) + "개");
            }
        }
    }

    public static void printEarning(double earning) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", earning);
    }
}
