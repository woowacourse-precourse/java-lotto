package lotto;

import java.util.List;

public class Buyer {
    private List<Lotto> buyingLotto;

    public void buy(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");

        }
    }
}
