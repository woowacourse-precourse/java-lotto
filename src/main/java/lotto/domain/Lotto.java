package lotto.domain;

import lotto.domain.enummodel.LottoEnum;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.LOTTO.getSize()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    //중복이 있는지 확인하는 메서드
    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoEnum.LOTTO.getSize()) {
            throw new IllegalArgumentException();
        }
    }

    //getter
    public List<Integer> getNumbers() {
        return numbers;
    }
}
