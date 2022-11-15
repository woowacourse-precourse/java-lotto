package lotto.data.dto;

import java.util.Collections;
import java.util.List;
import lotto.type.ConstantNumberType;
import lotto.type.ExceptionType;

public class LottoDto {
    private final List<Integer> numbers;

    public LottoDto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (hasWrongSize(numbers)) {
            throw ExceptionType.COUNT.getException();
        }
    }

    private boolean hasWrongSize(List<Integer> numbers) {
        return numbers.size() != ConstantNumberType.COUNT.getValue();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
