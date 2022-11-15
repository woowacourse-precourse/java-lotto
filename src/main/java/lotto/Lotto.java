package lotto;

import java.util.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (hasDuplicatedNumber(i, numbers.get(i), numbers)) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }

        if (checkNumberRange(numbers)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    /* 중복검사 */
    private boolean hasDuplicatedNumber(int indexNumber, int number, List<Integer> numbers) {
        for (int j = indexNumber + 1; j < numbers.size(); j++) {
            if (numbers.get(j) == number) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(1 <= number && number <= 45)) {
                return true;
            }
        }
        return false;
    }








    public void hasDuplicatedLottoNumberWithBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
