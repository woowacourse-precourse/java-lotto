package lotto.domain;

import java.util.Iterator;
import java.util.Map;

public class RateCalculator {
    private ComparingMachine comparingMachine = new ComparingMachine();
    public int calculateWinningMoney(Map<Integer,Integer> winningMoney){
        int sum = 0;
        Iterator<Integer> keys = winningMoney.keySet().iterator();
        while (keys.hasNext()){
            int key = keys.next();
            sum += key;
        }
        return sum;
    }

    public double calculateReturnOfRate(int purchaseMoney, int winningMoney){
        double rateMoney = ((double)winningMoney / (double) purchaseMoney) * 100;
        rateMoney = Math.round(rateMoney*100)/100.0;
        return rateMoney;
    }
}
