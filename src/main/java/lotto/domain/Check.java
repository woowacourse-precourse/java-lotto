package lotto.domain;

import static java.lang.Integer.parseInt;

import java.util.List;
import lotto.GameProcess;
import lotto.util.Constant;

public class Check {
    public static Integer countBuyLotto(String payMoney) {
        //try catch로 입력값 확인
        return parseInt(payMoney) / (Constant.MONEYUNIT);
    }
}
