package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;

public class LottoWin {
    private static final String SEPARATOR = ",";
    private final Lotto winningNumbers;

    public LottoWin(String numbers) {
        validateSeparator(numbers);
        this.winningNumbers = generateLotto(numbers);
    }

    private void validateSeparator(String numbers) {
        if(!numbers.contains(SEPARATOR)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SEPARATOR);
        }
    }

    private Lotto generateLotto(String numbers) {
        List<Integer> lottoNumbers = numbersToList(numbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> numbersToList(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
