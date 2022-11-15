package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.ExceptionMsg;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    private List<Lotto> history;
    private int amount;
    public Issue(String money){
        history = new ArrayList<>();
        amount = amount(money);
    }

    private int amount(String money){
        if(money.replaceAll("[^0-9]", "").length() != money.length()) {
            throw new IllegalArgumentException(ExceptionMsg.MONEY_UNIT);
        }
        int moneyNum = Integer.parseInt(money);
        if(moneyNum%1000 != 0){
            throw new IllegalArgumentException(ExceptionMsg.MONEY_UNIT);
        }
        return moneyNum/1000;
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
