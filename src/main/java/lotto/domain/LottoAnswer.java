package lotto.domain;

import java.util.List;

public class LottoAnswer {
    private final List<Integer> lottoAnswer;
    private final int bonusNumber;

    public LottoAnswer(List<Integer> lottoAnswer, int bonusNumber) {
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
    }

    public boolean isNumberInAnswer(int number) {
        if (lottoAnswer.contains(number)) {
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
