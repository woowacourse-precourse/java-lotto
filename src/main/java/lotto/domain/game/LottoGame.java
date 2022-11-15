package lotto.domain.game;

import lotto.system.AnswerLottoSystem;
import lotto.system.IoSystem;
import lotto.system.RandomLottoSystem;
import lotto.system.SettlementSystem;

public class LottoGame {
    private static final String ERROR_UN_SOLVING = "[ERROR] + %s";
    private final IoSystem io;

    public LottoGame(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    public void execute() {
        try {
            this.executeProcess();
        } catch (IllegalArgumentException exception) {
            io.println(exception.getMessage());
        } catch (Exception | OutOfMemoryError exception) {
            io.println(String.format(ERROR_UN_SOLVING, exception.getMessage()));
        }

    }

    private void executeProcess() {
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
