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


    private Lotto createLottoNum(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return new Lotto(numbers);
    }

    public List<Lotto> lotto(){
        while (history.size() < amount){
            history.add(createLottoNum());
        }
        return history;
    }
}
