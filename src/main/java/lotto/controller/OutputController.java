package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Raffle;
import lotto.model.database.Draw;
import lotto.model.database.Ticket;
import lotto.type.PrizeType;
import lotto.view.IntroduceView;
import lotto.view.LottoPurchaseNumberView;
import lotto.view.LottoStatisticView;
import lotto.view.View;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputController extends Controller{
    public void showIntroduce() {
        View view = new IntroduceView();
        view.show();
    }

    public void showLottoPurchaseNumber() {
        View view = new LottoPurchaseNumberView(this.getLotteries());
        view.show();
    }

    public void showStatistic() {
        Raffle raffle = this.getRaffle();
        List<Lotto> lotteries = this.getLotteries();
        Map<PrizeType, Integer> status = this.countPrizeType(raffle, lotteries);
        long profit = this.calculateProfit(status);

        View view = new LottoStatisticView(status, profit);
        view.show();
    }

    private List<Lotto> getLotteries() {
        Ticket ticket = Ticket.getInstance();
        return ticket.getAll();
    }

    private Raffle getRaffle() {
        Draw draw = Draw.getInstance();
        return draw.getLatest();
    }

    private Map<PrizeType, Integer> countPrizeType(Raffle raffle, List<Lotto> lotteries) {
        Map<PrizeType, Integer> status = new LinkedHashMap<>();

        for (Lotto lotto : lotteries) {
            PrizeType prizeType = raffle.getPrizeTypeWith(lotto);
            status.put(prizeType, status.getOrDefault(prizeType, 0) + 1);
        }

        return status;
    }

    private long calculateProfit(Map<PrizeType, Integer> status) {
        return status
                .keySet()
                .stream()
                .mapToLong(PrizeType::getReward)
                .sum();
    }
}
