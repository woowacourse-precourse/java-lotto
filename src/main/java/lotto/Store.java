package lotto;

import java.util.List;

public class Store {

    public List<Lotto> sell(User user, int num) {
        user.setMoney(num * Constants.LOTTO_PRICE);
        return null;
    }
}
