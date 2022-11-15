package lotto.model;

import java.util.List;

public class Calculator {

    private static final int PRICE_OF_LOTTO = 1000;
    private static final int EARNING_OF_1ST_PRIZE = 2000000000;
    private static final int EARNING_OF_2ND_PRIZE = 30000000;
    private static final int EARNING_OF_3RD_PRIZE = 1500000;
    private static final int EARNING_OF_4TH_PRIZE = 50000;
    private static final int EARNING_OF_5TH_PRIZE = 5000;

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

    public float calculateEarningRate() {
        int earned = userRanks[1] * EARNING_OF_1ST_PRIZE
                + userRanks[2] * EARNING_OF_2ND_PRIZE
                + userRanks[3] * EARNING_OF_3RD_PRIZE
                + userRanks[4] * EARNING_OF_4TH_PRIZE
                + userRanks[5] * EARNING_OF_5TH_PRIZE;
        float earningRate = earned / userInvestment * 100;
        return earningRate;
    }
}
