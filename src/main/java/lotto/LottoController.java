package lotto;

import computer.Computer;
import ui.InputUtils;
import user.PurchaseAmount;

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
        purchaseAmount = new PurchaseAmount(userInput);
    }

    public void start() {
        generateLotteryNumbers();
        getLottoPurchaseAmountFromUser();
    }
}
