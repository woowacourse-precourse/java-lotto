package lotto;

import lotto.domain.Machine;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

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

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            Integer bonusNumber = inputView.inputBonusNumber(winningNumbers);

            Machine machine = new Machine(winningNumbers, bonusNumber);
            Map<String, Integer> resultOfLottos = machine.judge(lottos);
            double ratio = machine.calculateRatioOfWinningsToInsertMoney(resultOfLottos, money);
            outputView.printResultOfLottos(resultOfLottos, ratio);

        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }
}
