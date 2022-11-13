package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

public class Validation {

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개입니다.");
        }
    }

    public static void validateDuplication(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);

        if (numbersSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45 범위입니다.");
            }
        }
    }

    public static void costValidate(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }

    public static int validateCostType(String costInput) {
        try {
            return Integer.parseInt(costInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
