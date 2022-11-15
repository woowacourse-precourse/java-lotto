package lotto;

import java.util.List;

public class User {
    private int money = 0;
    List<Lotto> lottos;

    public List<Lotto> getLottos(){
        return lottos;
    }
    public int getMoney() {
        return this.money;
    }

    public void inputAmount() {
        this.money = UserInput.moneyInput();
    }

    public void buyLotto() {
        this.lottos = Buyer.buyLotto(money);
    }
}
