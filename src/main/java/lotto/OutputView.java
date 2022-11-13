package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printUserLotto(List<Lotto> userLotto) {
        printAmount(userLotto.size());
        userLotto.stream()
                .forEach(System.out::println);
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printStatistics(int amount, Map<Reward, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(result);
    }

    public static void printResult(Map<Reward, Integer> result) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Reward r : result.keySet()) {

            if (r == Reward.SECOND) {
                System.out.println(
                        r.getCount() + "개 일치, 보너스 볼 일치 (" + decimalFormat.format(r.getReward()) + "원) - " + result.get(
                                r) + "개");
                continue;
            }
            System.out.println(
                    r.getCount() + "개 일치 (" + decimalFormat.format(r.getReward()) + "원) - " + result.get(r) + "개");
        }
    }
}
