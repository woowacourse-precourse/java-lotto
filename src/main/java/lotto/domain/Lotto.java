package lotto.domain;

import static lotto.utils.validate.NumberValidator.validateNumber;
import static lotto.utils.validate.NumberValidator.validateNumbersSize;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> distinctNumbers = getDistinctNumbers(numbers);
        validateNumbersSize(distinctNumbers);

        for (Integer number : distinctNumbers) {
            validateNumber(number);
        }
    }

    private List<Integer> getDistinctNumbers(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public int correctCount(List<Integer> winningLottoNumbers) {
        int count = 0;

        for (Integer winningLottoNumber : winningLottoNumbers) {
            if (numbers.contains(winningLottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getSortNumbers() {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

}
