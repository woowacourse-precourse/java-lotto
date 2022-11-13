package lotto;

import java.util.List;

public class User {
    List<List<Integer>> boughtLotto;

    // 로또 구매 개수 구현
    public int buyingLotto(int money){
        return money / 1000;
    }
}
