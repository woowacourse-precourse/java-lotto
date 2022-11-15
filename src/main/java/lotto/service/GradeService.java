package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoGrade;

public class GradeService {
    private LottoAnswer lottoAnswer;
    private List<Lotto> lottos;
    private List<LottoGrade> lottoGrades = new ArrayList<>();

    public GradeService(LottoAnswer lottoAnswer, List<Lotto> lottos) {
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
