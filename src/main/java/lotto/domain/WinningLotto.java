package lotto.domain;

import java.util.List;
import lotto.view.message.ExceptionMessage;

public class WinningLotto {
    private static final int BEGIN_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, Integer bonusNumber) {
        validate(winningNumbers, bonusNumber);
        lotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, Integer bonusNumber) {
        winningNumbers.stream().filter(this::isInvalidNumber).forEach(number -> raiseInvalidNumberException());

        if (isInvalidNumber(bonusNumber)) {
            raiseInvalidNumberException();
        }
    }

    private void raiseInvalidNumberException() {
        System.out.println(ExceptionMessage.INVALID_NUMBER.getMessage());
        throw new IllegalArgumentException();
    }

    private boolean isInvalidNumber(Integer number) {
        return number < BEGIN_NUMBER || number > END_NUMBER;
    }
}
