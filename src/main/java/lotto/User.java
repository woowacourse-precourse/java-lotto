package lotto;

import java.util.List;

public class User {

    private int amount = 0;
    List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
