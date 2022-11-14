package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        checkDuplicate(new HashSet<>(numbers));
    }

    private void checkDuplicate(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> buy_lotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void sort() {
        numbers.sort(Comparator.naturalOrder());
    }

    public List<Integer> getList() {
        return numbers;
    }

    public static boolean check_bonus(Lotto buy_numbers, int bonus) {
        return buy_numbers.getList().contains(bonus);
    }

    public static int check_win(List<Integer> win_numbers, Lotto buy_numbers) {
        int cnt = 0;
        for (int num : win_numbers) {
            if (buy_numbers.getList().contains(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static double check_profit(int[] statistics, double total) {
        total += statistics[0] * 5_000;
        total += statistics[1] * 50_000;
        total += statistics[2] * 1_500_000;
        total += statistics[3] * 30_000_000;
        total += statistics[4] * 2_000_000_000;
        return total;
    }

    public static int check_input_validate(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(input);
    }
}