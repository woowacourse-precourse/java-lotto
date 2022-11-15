package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    static void validateLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        } else if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다");
        } else if (outOfNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위 안의 수만 입력하세요");
        }
    }

    private static boolean hasDuplication(List<Integer> numbers) {
        Set<Integer> DuplicationCheck = new HashSet<>(numbers);

        return numbers.size() != DuplicationCheck.size();
    }

    private static boolean outOfNumberRange(List<Integer> numbers) {
        boolean outOfRange = false;

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                outOfRange = true;
                break;
            }
        }
        return outOfRange;
    }

    void printNumbers() {
        System.out.println(numbers);
    }
}