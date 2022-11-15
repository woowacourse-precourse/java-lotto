package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constants.ERROR_MESSAGE_FOR_SEED_MONEY;
import static lotto.Constants.MONEY_UNIT;

public class MyLotto {
    private int money;
    private int countNumsOfLotto;
    private List<List<Integer>> myPocket;

    MyLotto(int money) {
        validateMoney(money);
        this.money = money;
        this.countNumsOfLotto = money / MONEY_UNIT;
        this.myPocket = buyLotto(countNumsOfLotto);
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SEED_MONEY);
        }
    }

    private List<List<Integer>> buyLotto(int count) {
        List<List<Integer>> boughtLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> Lotto = LottoMachine.generateLotto();
            boughtLotto.add(Lotto);
        }
        return boughtLotto;
    }

    public List<List<Integer>> getMyPocket(){
        return this.myPocket;
    }
}
