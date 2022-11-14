package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class CalculateFactory {

    private final AllLotteriesCalculateService allLotteriesCalculateService;

    public CalculateFactory(List<Lotto> lotteries, Lotto winningLottery, int bonus){
        allLotteriesCalculateService = new AllLotteriesCalculateService(winningLottery, bonus);
        allLotteriesCalculateService.calculate(lotteries);
    }

    public Map<Rank, Integer> getResult() {
        return allLotteriesCalculateService.getResults();
    }

    public double getYield() {
        return allLotteriesCalculateService.getYield();
    }
}
