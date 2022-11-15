package lotto.domain;

import java.util.List;
import lotto.type.ErrorCode;
import lotto.type.LottoInformation;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i == numbers.size() - 1) {
                sb.append("]");
                continue;
            }
            sb.append(", ");
        }
        return sb.toString();
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != LottoInformation.SIZE.value()) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_SIZE_ERROR.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_ERROR.getMessage());
        }
    }
}
