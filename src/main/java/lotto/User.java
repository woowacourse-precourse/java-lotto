package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static int lottoMoney = 0;
    public final int PRICE_PER_LOTTO = 1000;
    Validator validator = new Validator();

    public int inputLottoPurchaseMoney(){
        lottoMoney = Integer.parseInt(Console.readLine());
        validator.validateMoneyInput(lottoMoney);
        return lottoMoney/PRICE_PER_LOTTO;
    }
}