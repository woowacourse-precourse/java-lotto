package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UI {
    public static void setMoney() {
        String money = Console.readLine();
        User user = new User(money);
    }
}
