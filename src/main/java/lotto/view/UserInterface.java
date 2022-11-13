package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    public void getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userMoney = Console.readLine();
    }
}
