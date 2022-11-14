package lotto.domain;

import static java.lang.Integer.parseInt;

import lotto.util.Constant;

public class Check {
    public static double countBuyLotto(double payMoney) {
        //try catch로 입력값 확인
        return payMoney/ (Constant.MONEYUNIT);
    }
}
