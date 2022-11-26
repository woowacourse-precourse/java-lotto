package lotto.domain;

import java.util.List;

import static lotto.validator.NumbersValidator.*;

public class Lotto {
    private final static int LOTTO_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        validateRangeNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
        }
    }

    // TODO: 추가 기능 구현

    public int getMatchingLottoNumberCount(Lotto lottoNumbers) {
        int matchingNumber = 0;
        for (int i = 0; i < LOTTO_COUNT; i++) {
            if (lottoNumbers.contains(numbers.get(i))) {
                matchingNumber++;
            }
        }
        return matchingNumber;
    }

    public boolean checkMatchingBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }

    public boolean contains(Object value) {
        return numbers.contains(value);
    }

    public int get(Object index) {
        return numbers.get((Integer) index);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
