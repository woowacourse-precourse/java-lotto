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

    // TODO: 추가 기능 구현
    public int countMatchedNumber(Lotto winningLotto){
        int count = (int) numbers.stream().filter(winningLotto::containNumber).count();
        return count;
    }

    protected boolean containNumber(int number) {
        return numbers.contains(number);
    }

}
