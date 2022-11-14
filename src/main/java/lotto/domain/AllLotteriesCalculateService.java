package lotto.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.model.Lotto;
import lotto.model.Rank;

public class AllLotteriesCalculateService {

    private static final int LOTTERY_PRICE = 1000;
    private static final int YIELD_PERCENTAGE = 100;

    private final EachLotteryCalculateService eachNumberCalculateService;
    private Map<Rank, Integer> results;
    private double yield;

    public AllLotteriesCalculateService(Lotto winningLottery, int bonus){
        eachNumberCalculateService = new EachLotteryCalculateService(winningLottery, bonus);
    }

    public void calculate(List<Lotto> lotteries){
        List<Rank> ranks = getAllWinningLotto(lotteries);
        Map<Rank, Integer> results = winningFormatter();
        ranks.forEach(
                rank -> results.put(rank, results.get(rank) + 1)
        );
        this.results = results;
        calculateYield(lotteries.size() * LOTTERY_PRICE);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getYield() {
        return yield;
    }

    private void calculateYield(int purchaseAmount){
        int prizeAmount = calculatePrizeAmount();

        yield = (prizeAmount  * YIELD_PERCENTAGE / (double)purchaseAmount);
    }

    private int calculatePrizeAmount(){
        AtomicInteger sum = new AtomicInteger();
        results.forEach( ((rank, integer) ->
                sum.addAndGet(rank.getPriceAmount() * integer)
                ));
        return sum.get();
    }


    private List<Rank> getAllWinningLotto(List<Lotto> lotteries){
        List<Rank> answer = new LinkedList<>();
        lotteries.forEach(lotto ->
                answer.add(eachNumberCalculateService.calculate(lotto))
        );
        return answer;
    }

    private Map<Rank, Integer> winningFormatter(){
        List<Rank> rankResults = Rank.rankFormatter();
        Map<Rank, Integer> results = new HashMap<>();
        rankResults.forEach(
                rank -> results.put(rank, 0)
        );
        return results;
    }

}
