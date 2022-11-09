package lotto.domain;

import java.util.List;

public class GradingMachine {
    private LottoAnswer lottoAnswer;
    private List<Lotto> lottos;
    private List<LottoGrade> lottoGrades;

    public GradingMachine(LottoAnswer lottoAnswer, List<Lotto> lottos) {
        this.lottoAnswer = lottoAnswer;
        this.lottos = lottos;
        this.run();
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
