package lotto.domain;

import java.util.LinkedList;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Rank;

public class EachLotteryCalculateService {

    private final static int BONUS_NUMBER = 5;

    private final Lotto winningLottery;
    private final int bonusNumber;

    public EachLotteryCalculateService(Lotto lottery, int bonusNumber){
        winningLottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculate(Lotto lottery){
        int matchedNumber = howManyMatchesNumber(lottery);
        Bonus bonus = Bonus.FALSE;

        if(isNeedBonusCheck(matchedNumber) && isContainsBonus(lottery)){
            bonus = Bonus.TRUE;
        }

        return Rank.getRank(matchedNumber, bonus);
    }

    public int howManyMatchesNumber(Lotto lottery){
        return lottery.getNumbers().stream()
                .filter( number -> winningLottery.getNumbers().contains(number) )
                .toArray()
                .length;
    }

    private boolean isNeedBonusCheck(int matchedNumber){
        return matchedNumber == BONUS_NUMBER;
    }

    private boolean isContainsBonus(Lotto lottery){
        return lottery.getNumbers().contains(bonusNumber);
    }

}
