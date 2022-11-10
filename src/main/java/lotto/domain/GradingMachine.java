package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GradingMachine {
    private LottoAnswer lottoAnswer;
    private List<Lotto> lottos;
    private List<LottoGrade> lottoGrades = new ArrayList<>();

    public GradingMachine(LottoAnswer lottoAnswer, List<Lotto> lottos) {
        this.lottoAnswer = lottoAnswer;
        this.lottos = lottos;
    }

    public void run() {
        for (Lotto lotto : lottos) {
            lottoGrades.add(grade(lotto));
        }
    }

    private LottoGrade grade(Lotto lotto) {
        LottoGrade lottoGrade = new LottoGrade();
        for (int number : lotto.getLotto()) {
            if (lottoAnswer.isNumberInAnswer(number)) {
                lottoGrade.increaseCorrectNumberCount();
            }
            if (lottoAnswer.isNumberEqaulToBonus(number)) {
                lottoGrade.makeBonusCorrect();
            }
        }
        return lottoGrade;
    }

    public List<LottoGrade> getLottoGrades() {
        return lottoGrades;
    }

}
