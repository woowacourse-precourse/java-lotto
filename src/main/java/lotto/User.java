package lotto;

import java.util.List;

public class User {

    private int amount = 0;
    List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAmount() {
        return this.amount;
    }

    public void inputAmount() {
        this.amount = UserInput.inputAmount();
    }

    public void buyLotto() {
        this.lottos = Buyer.buyLotto(amount);
    }
}
