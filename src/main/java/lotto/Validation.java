package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public static boolean isMultipleOf1000(int number) throws IllegalArgumentException {
        if (number % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
        return true;
    }

    public static void isLottoBetween1And45(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void isLottoDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않은 6개 숫자여야 합니다.");
//        return true;
    }

    public static boolean isBonusInLotto(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        if (numbers.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호에 없는 번호여야 합니다.");
        return true;
    }
}