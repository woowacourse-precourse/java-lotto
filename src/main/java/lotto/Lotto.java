package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        numbers.sort(Comparator.naturalOrder());
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for(String number: numbers.split(",")) {
            try {
                winningNumbers.add(Integer.parseInt(number));
            } catch (Exception e) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");
            }
        }

        winningNumbers.sort(Comparator.naturalOrder());
        validate(winningNumbers);
        this.numbers = winningNumbers;
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");

        checkNumberDuplicated(numbers);
        checkNumberInRange(numbers);
    }

    private void checkNumberDuplicated(List<Integer> numbers) {
        Integer beforeNumber = -1;

        for (Integer number: numbers) {
            if (beforeNumber == number)
                throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
            beforeNumber = number;
        }
    }

    private void checkNumberInRange(List<Integer> numbers) {
        for (Integer number: numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
