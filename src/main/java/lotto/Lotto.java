package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream().distinct().collect(Collectors.toList());
        validate(this.numbers);
        Collections.sort(this.numbers);
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP.getMessage());
        }
        validateElementRange(numbers);
    }

    private void validateElementRange(List<Integer> numbers) {
        numbers.forEach(i -> {
            if(isOutOfRange(i)) {
                throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
            }
        });
    }

    private boolean isOutOfRange(Integer value) {
        return value < LottoSetting.MIN_NUMBER.getValue() || value > LottoSetting.MAX_NUMBER.getValue();
    }
}
