package lotto.model;

import lotto.model.Lotto.BonusLotto;
import lotto.model.Lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    private Lotto lotto;
    private BonusLotto bonusLotto;

    private Map<Prize, Integer> result = new HashMap<>() {
        {
            put(Prize.SIX_STRIKE, 0);
            put(Prize.FIVE_STRIKE_WITH_BONUS, 0);
            put(Prize.FIVE_STRIKE, 0);
            put(Prize.FOUR_STRIKE, 0);
            put(Prize.THREE_STRIKE, 0);
        }
    };

    public Referee(Lotto lotto, BonusLotto bonusLotto) {
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
    }

    public Map<Prize, Integer> calculatePrizeOfAllTicket(List<List<Integer>> userTickets) {
        for (List<Integer> ticketNumbers : userTickets) {
            double score = calculatePrizeOfEachTicket(ticketNumbers);
            Prize findPrize = Prize.getPrizeByScore(score);

            if (findPrize == null) continue;
            int count = result.get(findPrize);
            result.put(findPrize, count + 1);
        }
        return this.result;
    }

    public double calculatePrizeOfEachTicket(List<Integer> ticketNumbers) {
        Double score = lotto.countWinLotto(ticketNumbers).doubleValue();
        if (score == 5.0 && bonusLotto.isBonusLotto(ticketNumbers)) {
            score += Score.BONUS.getScore();
        }
        return score;
    }

    public double calculateProfitRate(int inputMoney) {
        int profit = sumTotalProfit();
        double profitRate = ((double) profit / inputMoney) * 100;
        double roundOfProfitRate = Math.round(profitRate * 10) / 10.0;
        return roundOfProfitRate;
    }

    public int sumTotalProfit() {
        int totalProfit = 0;
        for (Map.Entry<Prize, Integer> entrySet : result.entrySet()) {
            Prize prize = entrySet.getKey();
            int prizeCount = entrySet.getValue();
            totalProfit +=  prize.calculate(prizeCount);
        }
        return totalProfit;
    }
}