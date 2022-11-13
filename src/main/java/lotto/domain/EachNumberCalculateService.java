package lotto.domain;

import java.util.LinkedList;
import lotto.model.Lotto;
import lotto.model.Rank;

public class EachNumberCalculateService {

    private final static int BONUSNUMBER = 5;

    private Lotto winningLottery;

    public EachNumberCalculateService(Lotto lottery){
        winningLottery = lottery;
    }


    public int howManyMatchesNumber(Lotto lottery){
        return lottery.getNumbers().stream()
                .filter( number -> winningLottery.getNumbers().contains(number))
                .toArray()
                .length;
    }

    private boolean isNeedBonusCheck(int matchedNumber){
        return matchedNumber == BONUSNUMBER;
    }

}
