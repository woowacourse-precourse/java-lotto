package lotto;

import java.util.List;

import static lotto.Constants.ERROR_MESSAGE_FOR_SEED_MONEY;

public class MyLotto {
    private int money;
    private int countNumsOfLotto;
    private List<List<Integer>> myLottoNumbers;

    MyLotto(int money) {
        validateMoney(money);
        this.countNumsOfLotto = money / 1000;
    }
    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_SEED_MONEY);
        }
    }
}
