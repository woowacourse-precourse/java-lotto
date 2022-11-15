package lotto;

import java.util.List;

public class Lotto extends IllegalArgumentException{
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호가 여섯 자리가 아닙니다.");
        }
        if(numbers.stream().distinct().count() != 6) throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨 번호가 범위 밖의 숫자입니다.");
            }
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return numbers.toString();
    }
}