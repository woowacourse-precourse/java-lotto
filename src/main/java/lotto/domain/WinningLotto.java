package lotto.domain;

import java.util.List;
import lotto.resource.Constant;
import lotto.resource.message.ExceptionMessage;

public class WinningLotto {
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

        if (winningNumbers.contains(bonusNumber)) {
            System.out.println(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void raiseInvalidNumberException() {
        System.out.println(ExceptionMessage.INVALID_NUMBER.getMessage());
        throw new IllegalArgumentException();
    }

    private boolean isInvalidNumber(Integer number) {
        return number < Constant.BEGIN_NUMBER.getValue() || number > Constant.END_NUMBER.getValue();
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
