package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        overlapNum(numbers);

        rangeNum(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void overlapNum(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            System.out.println("[ERROR] 중복 값 입력!");
            throw new IllegalArgumentException("[ERROR] 중복 값 입력");
        }
    }

    private void rangeNum(List<Integer> numbers) {
        for (int i : numbers) {

            if (!(i >= 1 && i <= 45)) {

                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

}
