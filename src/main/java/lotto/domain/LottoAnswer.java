package lotto.domain;

import java.util.List;

public class LottoAnswer {
    private final List<Integer> lottoAnswer;
    private final int bonusNumber;

    public LottoAnswer(List<Integer> lottoAnswer, int bonusNumber) {
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
    }
}
