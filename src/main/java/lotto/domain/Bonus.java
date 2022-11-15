package lotto.domain;


import lotto.view.ErrorMessage;

import java.util.List;

public class Bonus {
    private static final int BONUS_NUMBER_SIZE = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private List<Integer> bonusNumber;

    public Bonus(List<Integer> bonusNumber, Lotto winningLotto) {
        validateBonusSize(bonusNumber);
        validateRange(bonusNumber);
        validateDuplicateWinningLotto(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusSize(List<Integer> bonusNumber) {
        if (bonusNumber.size() != BONUS_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage
                    .GET_ERROR_FOR_INPUT_ONE_BONUS_NUMBER
                    .getMessage());
        }
    }

    private static void validateRange(List<Integer> bonusNumber) {
        for (Integer number : bonusNumber) {
            if (!(START_NUMBER <= number && number <= END_NUMBER)) {
                throw new IllegalArgumentException(ErrorMessage
                        .GET_ERROR_FOR_BONUS_NUMBER_RANGE
                        .getMessage());
            }
        }
    }

    private static void validateDuplicateWinningLotto(List<Integer> bonusNumber, Lotto winningLotto) {
        Integer bonus = bonusNumber.get(0);
        List<Integer> lotto = winningLotto.getLotto();
        for (Integer number : lotto) {
            if (bonus.equals(number)) {
                throw new IllegalArgumentException(ErrorMessage
                        .GET_ERROR_FOR_DUPLICATE_BONUS_WINNING
                        .getMessage());
            }
        }
    }
}
