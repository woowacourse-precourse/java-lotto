package lotto.domain.game;

import lotto.system.AnswerLottoSystem;
import lotto.system.IoSystem;
import lotto.system.RandomLottoSystem;
import lotto.system.SettlementSystem;

public class LottoGame {

    private final IoSystem io;

    public LottoGame(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    public void execute() {

        var randomLottoSystem = new RandomLottoSystem(io);
        var answerLottoSystem = new AnswerLottoSystem(io);
        var settlementSystem = new SettlementSystem(io);

        var lottoBundle = randomLottoSystem.generateLottoBundle();
        var answerLotto = answerLottoSystem.generateAnswerLotto();
        var purchaseLottoMoney = randomLottoSystem.getPurchaseLottoMoney();

        settlementSystem.printSettlementResult(lottoBundle, answerLotto);
        settlementSystem.printCalculateProfits(purchaseLottoMoney);
    }


}
