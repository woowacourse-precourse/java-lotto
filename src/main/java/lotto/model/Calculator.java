package lotto.model;

import java.util.List;

public class Calculator {

    private Lotto wonLotto;
    private int bonusNumber;
    private int[] userRanks;

    public Calculator(Lotto wonLotto, int bonusNumber){
        this.wonLotto = wonLotto;
        this.bonusNumber = bonusNumber;
        this.userRanks = new int[]{0, 0, 0, 0, 0, 0};
    }

    public void calculateLottoResult(List<Lotto> userLottos) {
        for (Lotto userlotto : userLottos) {
            Judgement judgement = new Judgement(){};
            int rank = judgement.judgeRank(userlotto, wonLotto, bonusNumber);
            userRanks[rank]++;
        }
    }
}
