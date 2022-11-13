package lotto;

import java.util.HashSet;
import java.util.List;

public class LottoValidator {

    public static void validateOverlap(List<Integer> numbers) {
        HashSet<Integer> appeared = new HashSet<>();
        for (int number : numbers) {
            if (appeared.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.");
            }
            appeared.add(number);
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 지정된 크기와 다릅니다.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호의 범위가 올바르지 않습니다.");
            }
        }
    }
}
