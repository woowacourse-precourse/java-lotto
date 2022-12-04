package lotto.service;

import lotto.domain.*;

import java.util.EnumMap;

public class LottoGameService {

    private Money money;
    private Lottos lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public void buyLottos(int inputMoney) {
        this.money = new Money(inputMoney);
        LottoFactory factory = new LottoFactory(new RandomNumbers());
        this.lottos = new Lottos(factory.generateLottos(this.money));
    }

    public int showLottosSize() {
        return lottos.size();
    }

    public String showLottosToString() {
        return lottos.toString();
    }

    public void checkWinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public EnumMap<LottoRank, Integer> showLottosRank() {
        return lottos.getLottoRanks(winningLotto, bonusNumber);
    }

    public double showProfitRate(EnumMap<LottoRank, Integer> lottoRanks) {
        int profit = lottoRanks.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(e -> e.getKey().getPrizeMoney() * e.getValue())
                .reduce(Integer::sum)
                .orElse(0);

        return this.money.getProfitRate(profit);
    }

}
