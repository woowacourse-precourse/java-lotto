package lotto;

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

    public int CountAfterComparison(List<Integer> lottoNumber, int bonusNumber) {
        int count = 0;
        for (int j = 0; j < lottoNumber.size(); j++) {
            for (int k = 0; k < numbers.size(); k++) {
                if (lottoNumber.get(j) == numbers.get(k)) {
                    count++;
                }
            }
        }
        if (count == 5) {
            for (int j = 0; j < lottoNumber.size(); j++) {
                if (lottoNumber.get(j) == bonusNumber) {
                    count = count + 2;
                    break;
                }
            }
        }
        return count;
    }

    // TODO: 추가 기능 구현
}
