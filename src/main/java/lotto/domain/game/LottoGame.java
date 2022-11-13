package lotto.domain.game;

import lotto.domain.money.Money;
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
        Money money = inputMoneyByUser();

        var randomLottoSystem = new RandomLottoSystem(io);
        var answerLottoSystem = new AnswerLottoSystem(io);
        var settlementSystem = new SettlementSystem(io);

        var lottoBundle = randomLottoSystem.generateLottoBundle(money);
        var answerLotto = answerLottoSystem.generateAnswerLotto();

        settlementSystem.result(lottoBundle, answerLotto);
        settlementSystem.calculateProfits(money);
    }

    private Money inputMoneyByUser() {
        io.println("구입금액을 입력해 주세요.");
        var money = Money.generatePurchaseLottoMoney(io.input());
        return money;
    }


}
