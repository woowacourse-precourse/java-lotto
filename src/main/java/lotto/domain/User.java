package lotto.domain;

import java.util.List;
import java.util.Map;

public class User {
    private int amountOfMoney;
    private List<Lotto> lottos;
    private Map<Ranking, Integer> numberOfLottosByRank;

    public User(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        lottos = buyLottos();
    }

    private List<Lotto> buyLottos() {
        lottos = Clerk.issueLottos(amountOfMoney);
        return lottos;
    }

    public Map<Ranking, Integer> checkResult(WinningLotto winningLotto) {
        RankedLottoCounter calculator = new RankedLottoCounter(winningLotto);
        numberOfLottosByRank = calculator.countRankedLottos(lottos);
        return numberOfLottosByRank;
    }

    public double calculateYield() {
        long winnings = 0L;
        for (Map.Entry<Ranking, Integer> entry : numberOfLottosByRank.entrySet()) {
            winnings += (long) entry.getKey().getReward() * entry.getValue();
        }
        return (double) winnings / amountOfMoney * 100;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
