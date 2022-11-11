package lotto.entity;

import static lotto.service.LottoService.COUNT;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(
                "로또는 " + COUNT + "개를 가져야 합니다. 입력 : " + numbers.size());
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return numbers.toString();
    }

}
