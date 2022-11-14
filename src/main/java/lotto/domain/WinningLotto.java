package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.ErrorMessages.WINNING_NUMBERS_NOT_INTEGER;
import static lotto.utils.ErrorMessages.WINNING_NUMBERS_SEPARATOR;

public class WinningLotto {
    private static final int NUMBERS_SIZE = 6;
    private static final String SEPARATOR = ",";
    private final Lotto winningLotto;

    public WinningLotto(String numbers) {
        validateSeparator(numbers);
        this.winningLotto = generateLotto(numbers);
    }

    private void validateSeparator(String numbers) {
        String [] winningNumbers = numbers.split(SEPARATOR);
        if(winningNumbers.length != NUMBERS_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SEPARATOR);
        }
    }

    private Lotto generateLotto(String numbers) {
        List<Integer> lottoNumbers = toIntegerList(numbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> toIntegerList(String numbers) {
        try {
            return Arrays.stream(numbers.split(SEPARATOR))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_NOT_INTEGER);
        }
    }

    public Lotto getWinningNumbers() {
        return this.winningLotto;
    }

    public int getMatchCount(List<Integer> lottoNumbers) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        long count = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
        return Long.valueOf(count).intValue();
    }
}
