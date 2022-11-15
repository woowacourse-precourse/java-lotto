package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        makeAscendingOrder(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueLottoNumbers = new HashSet<>();
        for (int lottoNumber : numbers) {
            if (!uniqueLottoNumbers.add(lottoNumber)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer countMatchNumbers(WinningNumber winningNumber) {
        int matchNumber = 0;
        for (int number = 0; number < numbers.size(); number++) {
            matchNumber += isMatched(numbers.get(number), winningNumber.getWinningNumbers());
        }
        return matchNumber;
    }

    private Integer isMatched(int myNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(myNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean haveBonusNumber(WinningNumber winningNumber) {
        if (numbers.contains(winningNumber.getBonusNumber())) {
            return true;
        }
        return false;
    }

    private void makeAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }

}
