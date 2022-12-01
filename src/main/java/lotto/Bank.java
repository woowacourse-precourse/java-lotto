package lotto;

import lotto.exception.MyIllegalArgumentException;

import java.util.List;

import static lotto.exception.ErrorCode.BONUS_NUMBER_ERROR;

public class Bank {
    private final static int WIN_SIZE = Rank.values().length;
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
        System.out.println("3개 일치 (5,000원) - " + payment[Rank.FIFTH.ordinal()] + "개");
        System.out.println("4개 일치 (50,000원) - " + payment[Rank.FOURTH.ordinal()] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + payment[Rank.THIRD.ordinal()] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + payment[Rank.SECOND.ordinal()] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + payment[Rank.FIRST.ordinal()] + "개");
    }
}
