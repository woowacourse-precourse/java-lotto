package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    List<Lotto> history;
    int amount;
    public Issue(int money){
        history = new ArrayList<>();
        amount = getAmount(money);
    }

    private int getAmount(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
        return money/1000;
    }
}
