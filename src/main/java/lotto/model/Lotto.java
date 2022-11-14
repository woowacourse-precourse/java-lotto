package lotto.model;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers.size());
        validateDuplicate(new HashSet<>(numbers).size());

        for (int number : numbers) {
            validateRange(number);
        }

    }

    protected void validateSize(int size) {
        if (size != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("쉼표를 기준으로 " + LottoRule.SIZE + "개의 값을 입력해주세요.");
        }
    }

    protected void validateDuplicate(int size) {
        if (size != LottoRule.SIZE.getValue()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }
    }

    protected void validateRange(int number) {
        if (number < LottoRule.START_NUMBER.getValue() || LottoRule.END_NUMBER.getValue() < number) {
            throw new IllegalArgumentException("로또 번호의 범위를 넘어갔습니다. 로또 번호는 " +
                    LottoRule.START_NUMBER + "부터 " + LottoRule.END_NUMBER + "까지 입니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
