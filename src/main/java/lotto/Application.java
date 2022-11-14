package lotto;

import static lotto.util.InputUtils.*;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class Application {

    public static void main(String[] args) {
        askPurchaseAmount();
        int purchaseAmount = getInt();
        validatePurchaseAmount(purchaseAmount);

    }
}
