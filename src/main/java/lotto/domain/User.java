package lotto.domain;

import java.util.List;
import java.util.Map;

public class User {
    private int amountOfMoney;
    private List<Lotto> lottos;
    private Map<Ranking, Integer> numberOfLottosByRank;
    private long winnings;

    public User(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        lottos = buyLottos();
    }

    private List<Lotto> buyLottos() {
        lottos = Clerk.issueLottos(amountOfMoney);
        return lottos;
    }

    public void CheckResult(WinningLotto winningLotto) {
        WinningsCalculator calculator = new WinningsCalculator(lottos, winningLotto);
        numberOfLottosByRank = calculator.getNumberOfRankedLottos();
        winnings = calculator.calculateWinnings();
    }

    public Map<Ranking, Integer> getNumberOfLottosByRank() {
        return numberOfLottosByRank;
    }

    public double getYield() {
        double yield = (double) winnings / amountOfMoney * 100;
        return yield;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
