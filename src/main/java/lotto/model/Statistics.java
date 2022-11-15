package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Prize, Integer> prizeTable = new HashMap<>();
    private int earnedMoney = 0;

    public void setPrizeTable(List<List<Integer>> results){
        initPrizeTable();
        for (List<Integer> result : results){
            Prize prize = findPrize(result.get(0), result.get(1));
            if (prize == null){
                continue;
            }
            if (prizeTable.containsKey(prize)){
                prizeTable.put(prize, prizeTable.get(prize)+1);
            }
        }
    }

    public void initPrizeTable(){
        for (Prize prize: Prize.values()){
            prizeTable.put(prize, 0);
        }
    }

    public Map<Prize, Integer> getPrizeTable(){
        return prizeTable;
    }

    public Prize findPrize(int matches, int bonus){
        if (matches == Prize.SECOND.getMatches() && bonus == 1){
            return Prize.SECOND;
        }
        if (matches == Prize.SECOND.getMatches()){
            return Prize.THIRD;
        }

        for (Prize prize: Prize.values()){
            if (prize.getMatches() == matches){
                return prize;
            }
        }
        return null;
    }

    public void setEarnedMoney(){
        for (Prize prize: Prize.values()){
            int money = prize.getMoney();
            int quantity = prizeTable.get(prize);

            earnedMoney += money*quantity;
        }
    }

    public double calculateRate(int userPurchaseAmount){
        double inputMoney = (double) userPurchaseAmount;
        double returnedMoney = (double) earnedMoney;

        double rate = inputMoney/returnedMoney;
        rate = Math.round((rate*100)/100);

        return rate;
    }
}
