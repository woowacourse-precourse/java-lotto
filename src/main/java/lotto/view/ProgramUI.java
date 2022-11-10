package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.Constants.*;

public class ProgramUI {
    public String moneyInput;

    public void inputMoney() {
        System.out.println(INPUT_MONEY);
        this.moneyInput = readLine();
    }
}
