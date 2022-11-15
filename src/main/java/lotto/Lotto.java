package lotto;


import java.util.List;
import java.util.stream.Collectors;

import static message.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkLottoByDuplicatedNumber(numbers);
        checkLottoNumberOver45(numbers);

        this.numbers = numbers;
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MORE_THAN_SIX_LOTTO.getStatus());
        }
    }


    private void checkLottoByDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO.getStatus());
        }
    }


    // TODO: 추가 기능 구현
    public void checkLottoNumberOver45(List<Integer> numbers) {
        final int startRange = 1;
        final int endRange = 45;
        for (int num : numbers) {
            if (!(num >= startRange || num <= endRange)) throw new IllegalArgumentException(ABOVE_ELEMENT.getStatus());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
