package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    List<Lotto> history;
    int amount;
    public Issue(int money){
        history = new ArrayList<>();
        amount = amount(money);
    }

    private int amount(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException();
        }
        return money/1000;
    }


    private Lotto lottoNum(){
        List<Integer> numbers = new ArrayList<>();
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for(Integer number : randomNumbers) {
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return new Lotto(numbers);
    }

    public List<Lotto> lotto(){
        while (history.size() < amount){
            history.add(lottoNum());
        }
        return history;
    }
    public double revenue(double winRevenue){
        return (winRevenue/(amount*1000))*100;
    }
}
