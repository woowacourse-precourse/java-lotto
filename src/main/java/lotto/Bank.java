package lotto;

import lotto.exception.MyIllegalArgumentException;

import java.util.List;

import static lotto.exception.ErrorCode.BONUS_NUMBER_ERROR;

public class Bank {
    private final static int[] MONEY = {0, 2000000000, 30000000, 1500000, 50000, 5000};
    private final static int WIN_SIZE = 6;
    private final Lotto winLotto;
    private final int bonusNumber;
    private final int[] payment;

    public Bank(Lotto winLotto, int bonusNumber) {
        validate(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
        this.payment = new int[WIN_SIZE];
    }

    private void validate(Lotto winLotto, int bonusNumber) {
        if (winLotto.contains(bonusNumber)) {
            throw new MyIllegalArgumentException(BONUS_NUMBER_ERROR);
        }
    }

    private int payMoney(Lotto userLotto) {
        int countOfMatch = userLotto.getCommonNumbers(winLotto).size();
        boolean bonusMatch = userLotto.contains(bonusNumber);
        Rank rank = Rank.getRank(countOfMatch, bonusMatch);
        payment[rank.ordinal()]++;
        return rank.getWinningMoney();
    }

    public long getTotalMoney(List<Lotto> lottos) {
        long totalMoney = 0;
        for (Lotto user : lottos) {
            totalMoney += payMoney(user);
        }
        return totalMoney;
    }

    public void printPayResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + payment[5] + "개");
        System.out.println("4개 일치 (50,000원) - " + payment[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + payment[3] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + payment[2] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + payment[1] + "개");
    }
}
