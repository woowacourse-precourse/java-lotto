package lotto.domain;

import static lotto.ui.ConsoleMessage.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto winningLottoNumbers;

    public WinningLotto(String winningLotto) {
        Lotto validatedLotto = validate(winningLotto);
        this.winningLottoNumbers = validatedLotto;
    }

    private Lotto validate(String winningLotto) {
        validateInputFormat(winningLotto);
        return new Lotto(Arrays.stream(winningLotto.split(",")).mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList()));
    }

    private void validateInputFormat(String winningLotto) {
        if (!winningLotto
                .matches("[1-9]?[0-9]\\,[1-9]?[0-9]\\,[1-9]?[0-9]\\,[1-9]?[0-9]\\,[1-9]?[0-9]\\,[1-9]?[0-9]")) {
            throw new IllegalArgumentException(INVALID_INPUT_WINNING_LOTTO.toString());
        }
    }

    public Lotto getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
