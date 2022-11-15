package lotto;

import static lotto.Cli.inputPurchaseAmount;
import static lotto.Cli.print;
import static lotto.Machine.createLotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = inputPurchaseAmount();
        int purchaseCount = amount / 1000;

        List<Lotto> lottoList = createLotto(purchaseCount);
        print(lottoList);
    }
}
