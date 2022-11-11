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
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(isDuplicate(numbers)) {
            System.out.println("[ERROR] 로또 번호는 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(!isCorrectRange(numbers)) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    private boolean isCorrectRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
