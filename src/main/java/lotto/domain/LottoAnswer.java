package lotto.domain;

import java.util.List;

public class LottoAnswer {
    private final Lotto lottoAnswer;
    private final int bonusNumber;

    public LottoAnswer(Lotto lottoAnswer, int bonusNumber) {
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
    }

    public boolean isNumberInAnswer(int number) {
        if (lottoAnswer.getLotto().contains(number)) {
            return true;
        }
        return false;
    }

    public boolean isNumberEqaulToBonus(int number) {
        if (bonusNumber == number) {
            return true;
        }
        return false;
    }
}
