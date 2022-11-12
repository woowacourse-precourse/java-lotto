package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6){
            System.out.println("[ERROR] 로또 번호는 총 6개의 숫자이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
