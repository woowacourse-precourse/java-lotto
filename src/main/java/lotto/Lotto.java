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
            System.out.println("[ERROR] 로또 번호는 6 개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            System.out.println("[ERROR] 로또 번호는 중복되어서는 안됩니다.");
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 46) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}
