package lotto;

import lotto.view.Input;

public class Application {
    public static void main(String[] args) {
        int Money = Input.askMoney();
        int lotto = Input.inputMoney(Money);
    }
}
