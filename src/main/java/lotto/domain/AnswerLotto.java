package lotto.domain;

import static lotto.view.SystemMessage.DUPLICATE_BONUS_ERROR_MESSAGE;
import static lotto.view.SystemMessage.ERROR_MESSAGE;
import static lotto.view.SystemMessage.LIMIT_NUMBER_ERROR_MESSAGE;

import java.util.List;

public class AnswerLotto {

    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerLotto, int bonusNumber) {
        validateAllLottoNumber(answerLotto);
        validateCheckNumberLimit(bonusNumber);
        validateDuplicateBonusNumber(answerLotto, bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerLotto() {
        return answerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateCheckNumberLimit(Integer num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LIMIT_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateCheckLimit(List<Integer> numbers) {
        for (Integer num : numbers) {
            validateCheckNumberLimit(num);
        }
    }

    private static void validateAllLottoNumber(List<Integer> numbers) {
        validateCheckLimit(numbers);
    }

    private static void validateDuplicateBonusNumber(List<Integer> answerLotto,
            Integer bonusNumber) {
        if (answerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_BONUS_ERROR_MESSAGE);
        }
    }
}
