package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputDevice {
    
    public int sendMoneyToBuyLotto() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
