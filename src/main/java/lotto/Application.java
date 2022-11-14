package lotto;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

import lotto.domain.Purchase;

public class Application {

    public static void main(String[] args) {
        askPurchaseAmount();

        Purchase purchase = new Purchase(getInt());

    }
}
