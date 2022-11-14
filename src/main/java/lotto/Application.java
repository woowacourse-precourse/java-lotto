package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        if (inputView.inputMoney()) {
            return;
        }
        if (inputView.inputWinningNumber()) {
            return;
        }
        inputView.inputBonus();
        for (List<Integer> randomLotto : inputView.calculator.lotteries) {
            inputView.lotto.compareLotto(randomLotto, inputView.bonusNum);
        }
        inputView.calculator.printResult();
    }
}
