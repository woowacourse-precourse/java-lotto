package lotto;

import lotto.view.InputView;

import java.math.BigInteger;

public class Application {
    private static final InputView inputView = new InputView();
    public static void main(String[] args) {
        try {
            BigInteger money = inputView.insertMoney();

        } catch (IllegalArgumentException exception) {

        }
    }
}
