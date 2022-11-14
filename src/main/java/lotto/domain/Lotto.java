package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers; // 인스턴스 변수, 변하지 않는 값(final) <-> static: 클래스 변수

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private  void validateDuplicationOfNumbers(List<Integer> numbers) {
        int[] checkDuplication = new int[46];
        for(Integer number : numbers){
            if (checkDuplication[number] == 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
            }
            checkDuplication[number] = 1;
        }
    }

    public int validateBonusNumber(String input) {
        validateIsDigitOfBonusNumber(input);
        int bonusNumber = Integer.parseInt(input);
        validateRangeOfBonusNumber(bonusNumber);
        validateDuplicationOfBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validateIsDigitOfBonusNumber(String bonusNumber) {
        if (bonusNumber.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicationOfBonusNumber(int bonusNumber) {
        int[] checkDuplication = new int[46];
        for(Integer number : numbers) {
            checkDuplication[number] = 1;
        }
        if (checkDuplication[bonusNumber] == 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다.");
        }
    }
}
