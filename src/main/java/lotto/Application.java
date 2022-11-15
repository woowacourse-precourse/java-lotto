package lotto;

import lotto.domain.Machine;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        try {
            BigInteger money = inputView.insertMoney();

            BigInteger numberOfLottos = Machine.countNumberOfLottos(money);
            List<Lotto> lottos = Machine.generateLottos(numberOfLottos);
            outputView.announceNumberOfPurchases(numberOfLottos);
            outputView.printLottos(lottos);

        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }
}
