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

    public void validateBonusNumber(int bonusNumber) {
        validateRangeOfBonusNumber(bonusNumber);
        validateDuplicationOfBonusNumber(bonusNumber);
    }

    private void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicationOfBonusNumber(int bonusNumber) {
        int[] checkDuplication = new int[46];
        for(Integer number : numbers) {
            checkDuplication[number] = 1;
        }
        if (checkDuplication[bonusNumber] == 1) {
            throw new IllegalArgumentException();
        }
    }
}
