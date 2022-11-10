package lotto;

import computer.Computer;
import utils.InputUtils;
import user.PurchaseAmount;
import utils.Validator;

public class LottoController {

    private final Computer computer;

    private PurchaseAmount purchaseAmount;

    public LottoController(Computer computer) {
        this.computer = computer;
    }

    private void generateLotteryNumbers() {
        computer.generateLotteryNumbers();
    }

    private void getLottoPurchaseAmountFromUser() {
        String userInput = InputUtils.getMoneyFromUser();

        Validator.checkLottoPurchaseAmountIsValid(userInput);

        purchaseAmount = new PurchaseAmount(Integer.parseInt(userInput));
    }

    public void start() {
        generateLotteryNumbers();
        getLottoPurchaseAmountFromUser();
    }
}
