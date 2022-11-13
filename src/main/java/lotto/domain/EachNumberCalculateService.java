package lotto.domain;

import java.util.LinkedList;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Rank;

public class EachNumberCalculateService {

    private final static int BONUSNUMBER = 5;

    private Lotto winningLottery;
    private int bonusNumber;

    public EachNumberCalculateService(Lotto lottery, int bonusNumber){
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
        return matchedNumber == BONUSNUMBER;
    }

    private boolean isContainsBonus(Lotto lottery){
        return lottery.getNumbers().contains(bonusNumber);
    }

}
