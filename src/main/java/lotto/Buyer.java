package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Buyer {

    Validator validator = new Validator();
    static int money;
    public Buyer(){

    }

    public int payMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        validator.validateMoneyOnlyNumber(inputMoney);
        int money = Integer.parseInt(inputMoney);
        validator.validateMoney(money);
        Buyer.money =money;
        return money;
    }
}
