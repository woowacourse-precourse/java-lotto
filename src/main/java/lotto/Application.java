package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount=Input.getPurchaseAmount();
        List<Lotto> lottos = Operation.buyLotto(amount);
        for(Lotto lotto: lottos) {
            lotto.printLotto();
        }
    }
}
