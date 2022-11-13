package lotto.domain;

import java.util.LinkedList;
import lotto.model.Lotto;
import lotto.model.Rank;

public class EachNumberCalculateService {
    Lotto winningLottery;

    public EachNumberCalculateService(Lotto lottery){
        winningLottery = lottery;
    }
    public void calculate(){

    }

    public int howManyMatchesNumber(Lotto lottery){
        return lottery.getNumbers().stream()
                .filter( number -> winningLottery.getNumbers().contains(number))
                .toArray()
                .length;
    }

}
