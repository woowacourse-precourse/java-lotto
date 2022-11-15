package lotto.model;

import java.util.List;

public class Calculator {

    private Lotto wonLotto;
    private int bonusNumber;

    public Calculator(Lotto wonLotto, int bonusNumber){
        this.wonLotto = wonLotto;
        this.bonusNumber = bonusNumber;
    }

    public void calculateLottoResult(List<Lotto> userLottos) {
        for (Lotto userlotto : userLottos) {
            Judgement judgement = new Judgement(){};
            judgement.checkMatch(userlotto, wonLotto, bonusNumber);
        }
    }
}
