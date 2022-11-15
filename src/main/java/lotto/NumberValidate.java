package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidate {
    public static void countSixValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 할 수 있습니다.");
        }
    }
    public static void duplicateValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호는 입력 할 수 없습니다.");
        }
    }

    public static void numbersInRangeValidate(List<Integer> numbers) {
        for (Integer number : numbers) {
            inRangeValidate(number);
        }
    }

    public static void inRangeValidate(int number) {
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 1~45의 정수만 입력 할 수 있습니다.");
        }
    }

    public static void digitValidate(String numbers) {
        if (!numbers.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 가능합니다.");
        }
    }

    public static void divideValidate(String numbers) {
        int digitPurchaseAmount = Integer.parseInt(numbers);
        if (digitPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위로 입력 할 수 있습니다.");
        }
    }
}
