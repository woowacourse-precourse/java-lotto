package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Prize {
    public static final String enterMoney = "구매금액을 입력해 주세요.";

    public Prize() {
        Integer money = getMoneyToBuyLotto();
        System.out.println(money);
    }

    public Integer getMoneyToBuyLotto(){
        System.out.println(enterMoney);
        String money = Console.readLine();
        return Integer.valueOf(money);
    }
}
