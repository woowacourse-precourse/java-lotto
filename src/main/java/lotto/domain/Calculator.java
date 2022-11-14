package lotto.domain;

import java.util.List;

public class Calculator {
    public static int calculateNumberOfLotto(int money) {
        return money / LottoValue.ONE_LOTTO_PRICE.getValue();
    }

    public static double calculateEarning(LottoLogic lottoLogic) {
        return (Hit.THREEHIT.getValue() * lottoLogic.getThreeHit()
                + Hit.FOURHIT.getValue() * lottoLogic.getFourHit()
                + Hit.FIVEHIT.getValue() * lottoLogic.getFiveHit()
                + Hit.FIVEHITANDBONUS.getValue() * lottoLogic.getFiveHitAndBonus()
                + Hit.SIXHIT.getValue() * lottoLogic.getSixHit());
    }

    public static double calculateEarningRate(LottoLogic lottoLogic) {
        double earning = calculateEarning(lottoLogic);
        return earning / lottoLogic.getMoney() * 100;
    }

    public static int comparePrizeNumber(Lotto lotto, List<Integer> prizeNumbers) {
        int count = 0;
        for (int prizeNumber : prizeNumbers) {
            if (lotto.getNumbers().contains(prizeNumber)) {
                count++;
            }
        }
        return count;
    }

    public static boolean compareBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}