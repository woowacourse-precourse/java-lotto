package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<List<Integer>> randomLottoNum(int num) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < num; i ++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            lotto = lotto.stream().sorted().collect(Collectors.toList());
            lottos.add(lotto);
        }

        return lottos;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        checkNumRange(numbers);
        this.numbers = numbers;
    }

    public static int lottoNum(int money){
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
        int num = money / 1000;

        System.out.println(num + "개를 구매했습니다.");
        return num;
    }

    public static List<Integer> lottoCount(List<List<Integer>> lottos, List<Integer> userLottos, int bonusNumber) {
        int arr[] = new int[userLottos.size()];

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> lotto = lottos.get(i);
            int number = count(lotto, userLottos, bonusNumber);
            arr[number]++;
        }

        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return result;
    }

    public static int count(List<Integer> lotto, List<Integer> input, int bonus) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (lotto.contains(input.get(i))) {
                count++;
            }
            if (count == 5 && lotto.contains(bonus)) {
                return 2;
            }
        }
        if (count == 6) return 1;
        if (count == 5) return 3;
        if (count == 4) return 4;
        if (count == 3) return 5;
        return 0;
    }

    public static String rate(List<Integer> grades, int money) {
        long profit = 0;

        profit += (long) 2_000_000_000 * grades.get(1);
        profit += (long) 30_000_000 * grades.get(2);
        profit += (long) 1_500_000 * grades.get(3);
        profit += (long) 50_000 * grades.get(4);
        profit += (long) 5_000 * grades.get(5);

        double result = profit / (double) money * 100;
        String rate = String.format("%.1f", result);
        return rate;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    public static void checkDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }


    public void checkNumRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= 1 || number <= 45)) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

}
