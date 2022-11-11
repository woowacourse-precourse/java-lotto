package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // 인스턴스 변수, 변하지 않는 값

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLengthOfNumbers(numbers);
        validateRangeOfNumbers(numbers);
        validateDuplicationOfNumbers(numbers);
    }

    private void validateLengthOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private  void validateDuplicationOfNumbers(List<Integer> numbers) {
        int[] checkDuplication = new int[46];
        for(Integer number : numbers){
            if (checkDuplication[number] == 1) {
                throw new IllegalArgumentException();
            }
            checkDuplication[number] = 1;
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int calculateQuantity(int money) {
        validateMonetaryUnit(money);
        return money / 1000;
    }

    private void validateMonetaryUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
