package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Output {
    public static void printLotto(int quantity, List<List<Integer>> lottery) {
        System.out.println(quantity + Initialize.PURCHASE.message());
        for (List<Integer> numbers : lottery) {
            List<Integer> converting = new ArrayList<>(numbers);
            Collections.sort(converting);
            System.out.println(converting);
        }
    }

    public static List<List<Integer>> issueLotto(int quantity) {
        List<List<Integer>> lottery = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottery.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottery;
    }

    public static List<Integer> getResult(List<Integer> winningNumbers, Integer bonus, List<List<Integer>> lottery) {
        Integer[] history = {0, 0, 0, 0, 0};
        for (List<Integer> numbers : lottery) {
            if (getCount(winningNumbers, numbers) == 3)
                history[0]++;
            if (getCount(winningNumbers, numbers) == 4)
                history[1]++;
            if (getCount(winningNumbers, numbers) == 5 && !winningNumbers.contains(bonus))
                history[2]++;
            if (getCount(winningNumbers, numbers) == 5 && winningNumbers.contains(bonus))
                history[3]++;
            if (getCount(winningNumbers, numbers) == 6)
                history[4]++;
        }
        return Arrays.asList(history);
    }

    public static void printResult(List<Integer> history) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + history.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + history.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + history.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + history.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + history.get(4) + "개");
    }

    public static void getRatio(int quantity, List<Integer> history) {
        double ratio = (5000 * history.get(0)
                + 50000 * history.get(1)
                + 1500000 * history.get(2)
                + 30000000 * history.get(3)
                + 2000000000 * history.get(4))
                / (double) (1000 * quantity) * 100;
        System.out.println(ratio);
        System.out.println("총 수익률은 " + String.format("%.1f", ratio) + "%입니다.");
    }

    public static Integer getCount(List<Integer> winningNumbers, List<Integer> numbers) {
        int count = 0;
        for (Integer i : winningNumbers) {
            if (numbers.contains(i))
                count++;
        }
        return count;
    }
}
