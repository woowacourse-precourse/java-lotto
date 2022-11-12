package lotto.service;

import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.model.Money;

public class GameService {
    private Money userMoney;
    private Lottos userLottos;
    private LottoFactory lottoFactory;

    public GameService() {
        this.lottoFactory = new LottoFactory();
    }

    public void createMoney(String userInput) {
        this.userMoney = Money.from(userInput);
    }

    public Lottos generateLottosByMoney() {
        this.userLottos = lottoFactory.generateBy(userMoney.calculateCount());
        return this.userLottos;
    }
}
