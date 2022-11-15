package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
    // TODO: 추가 기능 구현

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countSameNum(WinningNumbers winningNumbers) {
        return (int)numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

}
