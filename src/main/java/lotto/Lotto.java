package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumCheck(List<Integer> numbers) {
        for(int i = 0; i<numbers.size(); i++) {
            int tmp = numbers.get(i);
            lowerNumCheck(numbers, i, tmp);
        }
    }

    private void lowerNumCheck(List<Integer> numbers, int i, int tmp) {
        for(int j = i+1; j<numbers.size(); j++) {
            if(tmp == numbers.get(j)) {
                System.out.println("[ERROR] 중복된 숫자가 존재합니다");
                throw new IllegalArgumentException();
            }
        }
    }
}
