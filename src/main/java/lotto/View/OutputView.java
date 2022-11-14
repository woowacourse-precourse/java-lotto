package lotto.View;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.Reward;

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

    public static void printWinningNumber() {
        System.out.println();
        System.out.println("보너스 번호 입력해 주세요.");
    }

    public static void printStatistics(int amount, Map<Reward, Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        printResult(result);
        printYield(amount, result);
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

    public static void printYield(int amount, Map<Reward, Integer> result) {
        int sum = 0;
        for (Reward r : result.keySet()) {
            sum += r.getReward() * result.get(r);
        }
        String yield = String.format("%.1f", (double) sum / (double) (amount * 1000) * 100.0);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}