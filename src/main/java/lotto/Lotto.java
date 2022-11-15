package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateSame(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 수는 6개 입니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateSame(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>(numbers);
        while (!temp.isEmpty()) {
            int num = temp.get(0);
            temp.remove(0);
            if (!temp.isEmpty() && temp.contains(num)) {
                System.out.println("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호의 범위는 1 ~ 45입니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}