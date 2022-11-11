package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Validator {
    private Validator() {
    }

    public static void validate(List<Integer> numbers) {
        isProperSize(numbers);
        isAllNumberUnique(numbers);
        for (Integer number : numbers) {
            isInRange(number);
        }
    }

    private static void isProperSize(List<Integer> numbers) {
        if (numbers.size() != LottoRule.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 " + LottoRule.TOTAL_COUNT + "개여야 합니다.");
        }
    }

    private static void isAllNumberUnique(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoRule.TOTAL_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 없어야 합니다.");
        }
    }

    private static void isInRange(int number) {
        if (number < LottoRule.MIN_NUMBER || number > LottoRule.MAX_NUMBER) {
            throw new IllegalArgumentException
                    ("[ERROR] 로또 번호는 " + LottoRule.MIN_NUMBER + "보다 크거나 같고 " + LottoRule.MAX_NUMBER +"보다 작거나 같아야 합니다.");
        }
    }

}
