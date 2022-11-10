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

    // TODO: 추가 기능 구현
    public void printNumbers() {
        printFormat(this.numbers);
        return;
    }

    private void printFormat(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (i == numbers.size() - 1) {
                System.out.print(number);
                continue;
            }
            System.out.print(number + ", ");
        }
        System.out.println("]");
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
