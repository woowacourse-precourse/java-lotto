package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Customer {

    private static final String INPUT_MONEY = "구입 금액을 입력해주세요.";

    private int money;

    public void payMoney() {
        System.out.println(INPUT_MONEY);
        this.money = Integer.parseInt(Console.readLine());
    }

    public int getMoney() {
        return money;
    }


}
