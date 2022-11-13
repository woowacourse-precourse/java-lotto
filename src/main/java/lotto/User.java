package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int price;
    private float earningRate;


    public User(int price){
        validatePrice(price);
        this.price=price;
    }
    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
        if (price <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력 할 수 있습니다.");
        }

    }


}
