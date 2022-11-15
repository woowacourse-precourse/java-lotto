package lotto;

import java.util.List;

public class User {
    private int money = 0;
    List<Lotto> lottos;

    public List<Lotto> getLottos(){
        return lottos;
    }

    public void setMoney(int money){
        this.money = money;
    }
}
