package lotto.controller;

import static lotto.model.Changer.moneyToQuantityChanger;
import static lotto.model.Changer.stringToIntegers;

import java.util.List;
import lotto.model.InputValidator;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final User user = new User();

    public LottoController() {
    }

    public void start() {
        requestInputMoney();
    }

    private void requestInputMoney() {
        String moneyStr = InputView.requestInputMoney();
        if (!InputValidator.isValidMoney(moneyStr)) {
            return;
        }
        System.out.println();
        printPurchaseDetails(Integer.parseInt(moneyStr));
    }

    private void printPurchaseDetails(int money) {
        user.addMoney(money);
        int count = moneyToQuantityChanger(money);
        user.addRandomLotto(count);
        OutputView.printPurchaseDetails(count, user.getPurchaseDetails());
        System.out.println();
        requestTargetLottoNumbers();
    }

    private void requestTargetLottoNumbers() {
        String inputTargetLottoNumbers = InputView.requestInputTargetLottoNumbers();
        if (!InputValidator.isValidTargetLottoNumbers(inputTargetLottoNumbers)) {
            return;
        }
        List<Integer> targetLottoNumbers = stringToIntegers(inputTargetLottoNumbers);
        Lotto targetLotto = new Lotto(targetLottoNumbers);
        System.out.println();
        requestBonusNumber(targetLotto);
    }

    private void requestBonusNumber(Lotto targetLotto) {
        String inputBonusNumber = InputView.requestBonusNumber();
        if (!InputValidator.isValidBonusNumber(targetLotto, inputBonusNumber)) {
            return;
        }
        System.out.println();
        printResult(targetLotto, Integer.parseInt(inputBonusNumber));
    }

    private void printResult(Lotto targetLotto, int bonusNumber) {
        OutputView.printResult(user.getResult(targetLotto, bonusNumber));
        printProfitRate(targetLotto, bonusNumber);
    }

    private void printProfitRate(Lotto targetLotto, int bonusNumber) {
        OutputView.printProfitRate(user.getProfitRage(targetLotto, bonusNumber));
    }
}
