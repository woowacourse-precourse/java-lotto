package lotto.Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .toString();
    }

    public int getNumber(int i){
        return numbers.get(i);
    }

    private void validateSize(List<Integer> numbers){
        if(numbers.size()!=LottoInfo.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_SIZE));
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoInfo.LOTTO_START_RANGE.getNumber() || number > LottoInfo.LOTTO_END_RANGE.getNumber()) {
                throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_NUMBER_RANGE));
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        int[] count = new int[LottoInfo.LOTTO_END_RANGE.getNumber() + 1];
        for (Integer number : numbers) {
            count[number]++;
            if (count[number] > 1) {
                throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_UNIQUE_NUMBER));
            }
        }
    }
    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }
}
