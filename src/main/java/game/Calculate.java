package game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculate {
    public int grade(List<Integer> lotto, List<Integer> input, int bonus) {
        int cnt = 0;

        for (int i = 0; i < input.size(); i++) {
            if (lotto.contains(input.get(i))) cnt++;
            if (cnt == 5 && lotto.contains(bonus)) return 2;
        }

        if (cnt == 6) return 1;
        if (cnt == 5) return 3;
        if (cnt == 4) return 4;
        if (cnt == 3) return 5;
        return 0;
    }

    public List<Integer> correctLottoCount(List<List<Integer>> lottos, List<Integer> usersLotto, int bonusNum) {
        int[] arr = new int[usersLotto.size()];

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i);
            int num = grade(lotto, usersLotto, bonusNum);
            arr[num]++;
        }

        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());

        return result;
    }


    public String earningRate (List<Integer> grades, int money) {
        long profit = 0;

        profit += (long) 2_000_000_000 * grades.get(1);
        profit += (long) 30_000_000 * grades.get(2);
        profit += (long) 1_500_000 * grades.get(3);
        profit += (long) 50_000 * grades.get(4);
        profit += (long) 5_000 * grades.get(5);

        double result = profit / (double) money * 100;
        return String.format("%.1f",result)+"%";
    }
}
