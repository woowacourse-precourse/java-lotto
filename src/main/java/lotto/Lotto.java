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

    // 보너스 숫자를 추가하는 메서드
    public void addBonus(int bonus){
        numbers.add(bonus);
    }

    // TODO: 추가 기능 구현
}
