package lotto;

import java.util.List;

public class Seller {
    public void validateMoneyUnit(int money){
        if(money % 1000 != 0)
            throw new IllegalArgumentException();
    }
    public List<Lotto> sellLotto(int money){

    }
}
