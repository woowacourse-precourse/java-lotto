package lotto.domain;

import java.util.List;

public class User {
    private int amountOfmoney;
    private List<Lotto> lottos;

    public User(int amountOfmoney) {
        this.amountOfmoney = amountOfmoney;
    }

    private List<Lotto> buyLottos() {
        lottos = Clerk.issueLottos(amountOfmoney);
        return lottos;
    }
}
