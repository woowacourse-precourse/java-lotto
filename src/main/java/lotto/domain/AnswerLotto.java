package lotto.domain;

import static lotto.domain.SystemMessage.ERROR_MESSAGE;
import static lotto.domain.SystemMessage.LIMIT_NUMBER_ERROR_MESSAGE;

import java.util.List;

public class AnswerLotto {
    private final List<Integer> answerLotto;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerLotto, int bonusNumber) {
        validateAllLottoNumber(answerLotto);
        validateCheckNumberLimit(bonusNumber);
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerLotto() {
        return answerLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateCheckNumberLimit(Integer num){
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


}
