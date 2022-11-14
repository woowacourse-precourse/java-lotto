package lotto;

import static lotto.io.Message.ONLY_NUMBER;

import lotto.domain.PurchaseAmount;
import lotto.io.Reader;
import lotto.io.Writer;

public class LottoGame {

    private LottoGame() {

    }

    public static void run() {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (NumberFormatException e) {
            Writer.sendErrorMessage(ONLY_NUMBER);
        } catch (IllegalArgumentException e) {
            Writer.sendErrorMessage(e.getMessage());
        }
    }

    public void start() {
        PurchaseAmount amount = new PurchaseAmount(Reader.readUserPurchaseAmount());

    }

}
