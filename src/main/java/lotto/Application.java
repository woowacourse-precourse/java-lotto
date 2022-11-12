package lotto;

import lotto.domain.Price;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Price price = new Price(inputView.askPrice());
    }
}
