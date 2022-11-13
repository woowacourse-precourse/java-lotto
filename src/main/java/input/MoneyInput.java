package input;

import camp.nextstep.edu.missionutils.Console;

public class MoneyInput {

    public MoneyInput() {}

    public int getPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

}
