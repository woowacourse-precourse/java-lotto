package lotto.domain.user;

import lotto.domain.lotto.LottoInfo;
import lotto.error.ErrorMsg;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int money;
    private final List<Lotto> lotto;

    public User(String money) {
        validateMoney(money);
        this.money = Integer.parseInt(money);
        lotto = new ArrayList<>();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public int getMoney() {
        return money;
    }

    public void buyLotto(Lotto lotto){
        this.lotto.add(lotto);
    }

    private void validateMoney(String money) throws IllegalArgumentException{
        try {
            Integer.parseInt(money);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
        if (Integer.parseInt(money) % LottoInfo.PRICE.getValue() != 0)
            throw new IllegalArgumentException(ErrorMsg.WRONG_BUYING_UNIT.toString());
    }
}
