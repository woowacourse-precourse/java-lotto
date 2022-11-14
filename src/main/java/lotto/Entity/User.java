package lotto.Entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int MONEY_UNIT = 1000;

    private List<Lotto> lottos;
    private int money;
    private int buyCount;

    public void setMoney(int money) {
        this.money = money;
        this.buyCount = calBuyCount();
    }

    public void buyLotto(){
        lottos = new ArrayList<>();
        for(int i=0; i< buyCount; i++){
            lottos.add(Lotto.of());
        }
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    private int calBuyCount(){
        return money / MONEY_UNIT;
    }
}
