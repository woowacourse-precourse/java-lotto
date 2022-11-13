package lotto.model;

import static lotto.utils.LottoConstant.ERROR_MESSAGE_PREFIX;
import static lotto.utils.LottoConstant.RIGHT_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        sortedNumbers.addAll(0, numbers);
        sortedNumbers.sort(null);
        return sortedNumbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "추첨 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> lotto) {
        if (lotto.size() != lotto.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX + "중복된 추첨 번호가 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
