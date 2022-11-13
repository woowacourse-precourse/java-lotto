package lotto.domain.lotto;

import lotto.domain.score.Score;

public class AnswerLotto {
    public static final String ERROR_DUPLICATED_BONUS_NUMBER = "[ERROR] 보너스 로또 번호가 기존의 중복된 로또 번호를 가지고 있습니다.";

    private final Lotto answerLotto;
    private final LottoNumber bonusNumber;

    public AnswerLotto(Lotto answerLotto, LottoNumber bonusNumber) {
        validateBonusNumberIsDuplicatedAtLotto(answerLotto, bonusNumber);

        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }


    public Score compareLotto(Lotto randomLotto) {
        var score = Score.generateEmptyScore();

        var correctCount = this.answerLotto.compareCount(randomLotto);

        for (int i = 0; i < correctCount; i++) {
            score = score.plusNormal();
        }

        if (randomLotto.hasLottoNumber(bonusNumber)) {
            score = score.plusBonus();
        }
        return score;
    }

    private void validateBonusNumberIsDuplicatedAtLotto(Lotto answerLotto, LottoNumber bonusNumber) {
        var numbers = answerLotto.numbers();

        if (numbers.contains(bonusNumber.number())) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_BONUS_NUMBER);
        }
    }

}
