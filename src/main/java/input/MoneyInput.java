package input;

import camp.nextstep.edu.missionutils.Console;
import util.ExceptionMessage;

public class MoneyInput {

    public MoneyInput() {}

    public int getPurchaseAmount() {
        String input = Console.readLine();
        int money = validateConvertingMoney(input);
        return money;
    }

    private int validateConvertingMoney(String input) {
        int money = 0;

        try {
            money = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NOT_MONEY_FORMAT);
        }

        return money;
    }

}
