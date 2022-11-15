package lotto.service;

import lotto.domain.*;

import java.util.EnumMap;

public class LottoGameService {

    private Lottos lottos;
    private Lotto winningLotto;
    private int bonusNumber;

    public void buyLottos(int inputMoney) {
        Money money = new Money(inputMoney);
        LottoFactory factory = new LottoFactory(new RandomNumbers());
        this.lottos = new Lottos(factory.generateLottos(money));
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

}
