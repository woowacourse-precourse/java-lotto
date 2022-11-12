package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        checkNumberLength(numbers);

        for (Integer number : numbers) {
            checkNumberRange(number);
        }

        makeSureUniqueNumbers(numbers);
    }

    public void validateBonus(int bonusNumer) throws IllegalArgumentException {
        checkNumberRange(bonusNumer);

        makeSureUniqueNumber(bonusNumer, numbers);
    }

    private void checkNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자의 갯수는 6개만 가능합니다.");
        }
    }

    private void checkNumberRange(int number) throws IllegalArgumentException {
        if (!(number>=1 && number <=45)) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45까지만 가능합니다.");
        }
    }

    private void makeSureUniqueNumbers(List<Integer> numbers) throws IllegalArgumentException{
        Set uniqueNumbersCounter = new HashSet(numbers);
        if (uniqueNumbersCounter.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자 입력은 불가능 합니다.");
        }
    }

    private void makeSureUniqueNumber(int number, List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 이미 있던 숫자와 중복 할 수 없습니다.");
        }
    }
}
