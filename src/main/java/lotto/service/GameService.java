package lotto.service;

import lotto.model.BonusBall;
import lotto.model.LottoFactory;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Result;
import lotto.model.WinningManager;

public class GameService {
    private Money userMoney;
    private Lottos userLottos;
    private LottoFactory lottoFactory;
    private WinningManager winningManager;
    private Result result;

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

    public void createWinningManager(String userInput) {
        this.winningManager = WinningManager.from(userInput);
    }

    public void createBonusBall(String userInput) {
        this.winningManager.initBonusBall(BonusBall.from(userInput));
    }

    public Result calculateResult() {
        return this.result = Result.of(winningManager.resultBy(userLottos));
    }

    public String calculateProfitRate() {
        return this.userMoney.calculateProfitRate(result);
    }
}
