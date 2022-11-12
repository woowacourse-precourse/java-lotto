package lotto;

import lotto.model.Money;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        try {
            Money money = new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
