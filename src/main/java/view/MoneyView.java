package view;

import camp.nextstep.edu.missionutils.Console;

public class MoneyView {

    public String show() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        return money;
    }
}
