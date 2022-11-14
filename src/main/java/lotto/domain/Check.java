package lotto.domain;

import static java.lang.Integer.parseInt;

import lotto.util.Constant;

public class Check {
    public static Integer countBuyLotto(String payMoney) {
        return parseInt(payMoney) / (Constant.MONEYUNIT);
    }
}
