package lotto;

import lotto.domain.Lotto;
import lotto.domain.Manager;
import lotto.domain.User;
import lotto.util.ExceptionHandler;
import lotto.util.InputUtil;
import lotto.util.OutputUtil;

import java.util.List;

public class Application {

    User user = new User();
    Manager manager = new Manager();

    private void run() {
        try {
            setInputMoney();
            printPurchaseResult();
            setInputWinningNumber();
            setInputBonusNumber();
            manager.judgeResult(user);
            user.calculateYield();
            OutputUtil.printResult(user);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printEndProgram();
        }
    }

    private void setInputMoney() throws IllegalArgumentException {
        OutputUtil.printInputPurchaseAmount();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationMoney(input);
            double money = Double.parseDouble(input);
            user.setMoney(money);
            List<Lotto> lottos = manager.changeLottos(money);
            user.setLottos(lottos);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputWinningNumbersError();
            throw illegalArgumentException;
        }
    }

    private void printPurchaseResult() {
        OutputUtil.printUserLottoCount(user);
        OutputUtil.printUserLottos(user);
    }

    private void setInputWinningNumber() throws IllegalArgumentException {
        OutputUtil.printInputWinningNumbers();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationWinningNumber(input);
            manager.setWinningNumbers(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputWinningNumbersError();
            throw illegalArgumentException;
        }
    }

    private void setInputBonusNumber() throws IllegalArgumentException {
        OutputUtil.printInputBonusNumber();
        String input = InputUtil.getUserInput();
        try {
            ExceptionHandler.checkValidationBonusNumber(input, manager.getWinningNumbers());
            manager.setBonusNumber(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputUtil.printInputBonusNumberError();
            throw illegalArgumentException;
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
