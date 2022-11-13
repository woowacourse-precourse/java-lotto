package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    public int correctCount(List<Integer> winningLottoNumbers) {
        int count = 0;

        for (Integer winningLottoNumber : winningLottoNumbers) {
            if (numbers.contains(winningLottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getSortNumbers() {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
