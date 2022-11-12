package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int buyAmount;

    private List<Lotto> myLotto = new ArrayList<>();

    public void setMyLotto(Lotto lotto) {
        myLotto.add(lotto);
    }

    public List<Lotto> getMyLotto() {
        return myLotto;
    }

    public void setBuyAmount(String buyAmount){
        this.buyAmount = Integer.parseInt(buyAmount);
    }
}
