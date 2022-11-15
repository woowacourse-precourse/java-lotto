package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        try {
            BigInteger money = inputView.insertMoney();

        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }
}
