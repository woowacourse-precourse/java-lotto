package lotto.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class AllLotteriesCalculateService {

    private final EachLotteryCalculateService eachNumberCalculateService;

    public AllLotteriesCalculateService(Lotto winningLottery, int bonus){
        eachNumberCalculateService = new EachLotteryCalculateService(winningLottery, bonus);
    }

    public Map<Rank, Integer> calculate(List<Lotto> lotteries){
        List<Rank> ranks = getAllWinningLotto(lotteries);
        Map<Rank, Integer> results = winningFormatter();
        ranks.forEach(
                rank -> results.put(rank, results.get(rank) + 1)
        );
        return results;
    }

    public List<Rank> getAllWinningLotto(List<Lotto> lotteries){
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
