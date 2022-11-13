package lotto;

import camp.nextstep.edu.missionutils.Console;

// enum 사용해보자
public class User {

    private int money = 0;

    private void setMoney() {
        String input = Console.readLine();
        this.money = Integer.parseInt(input);
    }

}
