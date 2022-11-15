package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public void validate(List<Integer> lottoNumbers) {
        if(!isLottoRange(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_NOT_VALID_RANGE.getMessage());
        }
        if(!isSixNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_NOT_SIX_NUMBERS.getMessage());
        }
        if(!hasNotDuplicateNumber(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    @Override
    public String toString() {
        return numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    public int compare(Lotto lotto) {
        return (int) numbers.stream()
                .filter(number -> lotto.getNumbers().stream()
                .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private boolean isLottoRange(List<Integer> lottoNumbers) {
        for(int number : lottoNumbers) {
            if(!(0 < number && number < 46)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSixNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.size() == 6;
    }

    private boolean hasNotDuplicateNumber(List<Integer> lottoNumbers) {
        return (new HashSet<>(lottoNumbers)).size() == 6;
    }
}
