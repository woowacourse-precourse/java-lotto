package lotto.lotto;

import lotto.AllLottoMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(AllLottoMessage.INVALIDATE_NUMBER_SIZE.getMessage());
        }
    }
    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicationNumbers = new HashSet<>(numbers);

        if (nonDuplicationNumbers.size() != 6) {
            throw new IllegalArgumentException(AllLottoMessage.INVALIDATE_DUPLICATION.getMessage());
        }
    }

    public List<Integer> setLotto() {
        return numbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }
}
