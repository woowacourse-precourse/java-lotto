package lotto.model;

import java.util.List;
import lotto.model.vallidator.MoneyValidator;

public class User {
    private final int money;
    private final List<Lotto> lottos;

    public User(int money){
        MoneyValidator.validate(money);
        this.money = money;
        this.lottos = Lotto.buyLottos(money);
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
