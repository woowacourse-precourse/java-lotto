package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    int inputMoney() {
        String money = readLine();
        inputValidate(money);
        return Integer.parseInt(money);
    }
}
