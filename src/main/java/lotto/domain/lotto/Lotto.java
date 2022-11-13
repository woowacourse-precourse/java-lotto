package lotto.domain.lotto;

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

    public boolean contains(int lottoNum) {
        return numbers.contains(lottoNum);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) (numbers.stream().filter(otherLotto::contains).count());
    }

    // TODO: 추가 기능 구현
}
