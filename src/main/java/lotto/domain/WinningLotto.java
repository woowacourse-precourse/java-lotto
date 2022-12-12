package lotto.domain;

import lotto.utils.IntegerConvertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_NOT_INTEGER;
import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;

public class WinningLotto {
    private static final int NUMBERS_SIZE = 6;
    private static final String SEPARATOR = ",";

    private final Lotto winningLotto;

    public WinningLotto(String numbers) {
        validateSeparator(numbers);
        this.winningLotto = initWinningLotto(numbers);
    }

    private void validateSeparator(String numbers) {
        if (getNumbersSize(numbers) != NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SEPARATOR);
        }
    }

    private int getNumbersSize(String numbers) {
        return (int) Stream.of(numbers.split(SEPARATOR)).count();
    }

    private Lotto initWinningLotto(String numbers) {
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(SEPARATOR))
                .map(number -> IntegerConvertor.toInteger(number, WINNING_NUMBERS_NOT_INTEGER))
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    public int getMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this::contain)
                .count();
    }

    public Lotto getWinningNumbers() {
        return this.winningLotto;
    }

    public boolean contain(Integer number) {
        return winningLotto.contain(number);
    }

}
