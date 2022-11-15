package lotto;

import lotto.domain.Rank;
import java.util.List;
import static lotto.exception.ExceptionMessages.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(InvalidNumbersSizeMessage));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> validateSet = new HashSet<>();
        numbers.forEach((number) -> {
            if (!validateSet.add(number)) {
                throw new IllegalArgumentException(String.valueOf(DuplicateLottoNumbersMessage));
            }
        });
    }

    public Rank checkRank(List<Integer> winningNumbers, int bonusNumber) {
        int countOfMatch = getCountOfMatch(winningNumbers);
        return Rank.valueOf(countOfMatch, isMatchBonusNumber(bonusNumber));
    }

    private boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private int getCountOfMatch(List<Integer> winningNumbers) {
        int countOfMatch = 0;
        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                countOfMatch++;
            }
        }
        return countOfMatch;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String numbersToString() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach((number) -> sb.append(number).append(", "));
        return sb.substring(0, sb.length() - 2) + "]";
    }

    public void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.valueOf(InvalidBonusNumberMessage));
        }
    }
}