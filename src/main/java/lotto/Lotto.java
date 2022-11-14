package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateLength(numbers);
        validatedLottoRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validatedLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) throws IllegalArgumentException {
        if ((number < 1) || (number > 45)) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_RANGE.getValue());
        }
    }

    private void validateDuplicate(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> checkDuplicate = new HashSet<>(numbers);
        if (checkDuplicate.size() != 6) {
            throw new IllegalArgumentException(Error.ERROR_LOTTO_NUMBER_DUPLICATE.getValue());
        }
    }

    public int findLottoNumber(int index) {
        return numbers.get(index);
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(numbers.get(0));
        for (int lottoIndex = 1; lottoIndex < numbers.size(); lottoIndex++) {
            sb.append(", ");
            sb.append(numbers.get(lottoIndex));
        }
        sb.append("]");
        return sb.toString();
    }
}
