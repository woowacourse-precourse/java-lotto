package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateRange(numbers);
        lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        List<Integer> numbersToBeValidated = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbersToBeValidated.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 겹치는 로또 번호가 존재합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(number -> number < 1 || number > 45 );
        if (isOutOfRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.");
        }
    }
}
