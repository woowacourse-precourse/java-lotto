package lotto.domain;

import java.util.List;

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

    public boolean isMatchBonusNumber(List<Integer> winningLottoNumbers) {
        return numbers.contains(winningLottoNumbers.get(6));
    }

    // TODO: 추가 기능 구현
}
