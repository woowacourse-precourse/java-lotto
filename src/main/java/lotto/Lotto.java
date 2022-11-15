package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_OVERLAP = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().
                filter(winningLotto::containNumber).
                count();
    }

    public boolean containNumber(int number) {

        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_NUMBER_SIZE);
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }

        if (overlapCheck.size() != 6) {
            throw new IllegalArgumentException(NOT_NUMBER_OVERLAP);
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NOT_NUMBER_OVERLAP);
        }
    }
}
