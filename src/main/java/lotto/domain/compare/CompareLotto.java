package lotto.domain.compare;


import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.settlementsysyem.Score;

public class CompareLotto {

    public static Score compare(AnswerLotto answerLotto, Lotto randomLotto) {

        var lotto = answerLotto.getLotto();

        var score = compare(lotto, randomLotto);

        var bonusNumber = answerLotto.getBonusNumber();

        if (randomLotto.hasLottoNumber(bonusNumber.number())) {
            score = score.plusBonus();
        }
        return score;
    }

    private static Score compare(Lotto answerLotto, Lotto randomLotto) {
        var score = Score.generateEmptyScore();

        var count = answerLotto.compareCount(randomLotto);

        for (int i = 0; i < count; i++) {
            score = score.plusNormal();
        }
        return score;
    }
}
