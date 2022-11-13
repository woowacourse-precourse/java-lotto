package lotto.domain.game;

import java.util.List;

import static lotto.domain.game.LottoString.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_COUNT = 6;

    public Lotto(List<Integer> winningNumbers) {
        validateSizeWinningNumber(winningNumbers);
        this.numbers = winningNumbers;
    }

    private void validateSizeWinningNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(NO_MATCH_LOTTO_COUNT.print());
        }
    }

}
