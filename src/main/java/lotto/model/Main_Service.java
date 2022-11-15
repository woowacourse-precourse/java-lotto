package lotto.model;

import lotto.Constant;

public class Main_Service {
    public Constant constant;

    public int get_NumberOfLotto(int money) {
        return money / constant.LOTTO_PRICE.getNum();
    }

}
