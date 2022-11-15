package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinLotto extends Lotto {
    int bonus;

    public WinLotto(List<Integer> numbers) {
        super(numbers);
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateWinLottoNumbersRange(numbers);
    }

    public void validateWinLottoNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Application.LOTTO_START || number > Application.LOTTO_END) {
                throw new IllegalArgumentException(Message.ERROR_LOTTO_INPUT.message);
            }
        }
    }
}
