package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    private int money;

    public int getMoney(){
        inputMoney();
        return money;
    }

    private void inputMoney(){
        String playerMoney = Console.readLine();
        money = Integer.parseInt(playerMoney);
    }
}
