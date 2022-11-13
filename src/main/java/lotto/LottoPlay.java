package lotto;

import lotto.console.Output;
import lotto.controller.Processing;
import lotto.controller.Receive;
import lotto.domain.Lotto;

import java.util.List;

public class LottoPlay {
    private final Receive receive = new Receive();
    private final Processing processing = new Processing();
    private final Output output = new Output();

    public void play() {
        try {
            int money = receive.receiveAndPrintMoney();
            List<Lotto> lotto = receive.receiveAndPrintlottos(money);
            List<Integer> winningNumbers = receive.receiveAndPrintWinningNumbers();
            int bonusNumber = receive.receiveAndPrintBonusNumber(winningNumbers);

            processing.printAndDataProcessing(lotto, winningNumbers, bonusNumber, money);
        } catch (IllegalArgumentException exception) {
            output.printErrorMessage(exception.getMessage());
        }
    }
}
