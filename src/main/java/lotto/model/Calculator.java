package lotto.model;

import java.util.List;

import static lotto.utils.PrizeInfo.*;

public class Calculator {

    private static final int PRICE_OF_LOTTO = 1000;

    private Lotto wonLotto;
    private int bonusNumber;
    private int[] userRanks;
    private int userInvestment;

    public Calculator(Lotto wonLotto, int bonusNumber, List<Lotto> userLottos){
        this.wonLotto = wonLotto;
        this.bonusNumber = bonusNumber;
        this.userRanks = new int[]{0, 0, 0, 0, 0, 0};
        this.userInvestment = PRICE_OF_LOTTO * userLottos.size();
    }

    public int[] countLottoRanks(List<Lotto> userLottos) {
        for (Lotto userlotto : userLottos) {
            Judgement judgement = new Judgement(){};
            int rank = judgement.judgeRank(userlotto, wonLotto, bonusNumber);
            userRanks[rank]++;
        }
        return userRanks;
    }

    public double calculateEarningRate() {
        double earned = userRanks[1] * PRIZE1.getReward()
                + userRanks[2] * PRIZE2.getReward()
                + userRanks[3] * PRIZE3.getReward()
                + userRanks[4] * PRIZE4.getReward()
                + userRanks[5] * PRIZE5.getReward();
        double earningRate = earned / userInvestment * 100;
        return earningRate;
    }
}
