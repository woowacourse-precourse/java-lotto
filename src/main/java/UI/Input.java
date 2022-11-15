package UI;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Constants.ERROR_MESSAGE_FOR_IS_NUMERIC;
import static lotto.Constants.ERROR_MESSAGE_FOR_PROPER_MONEY;

public class Input {
    public static int inputSeedMoney() {
        String assumeMoney = readLine();
        validateNumeric(assumeMoney);
        int money = Integer.parseInt(assumeMoney);

    }

    public static boolean isNumeric(String money){
        return money.chars().allMatch(Character::isDigit);
    }

    public static int validateNumeric(String money) {
        if (!isNumeric(money)){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_IS_NUMERIC);
        }
    }
    public static int validateRangeOfMoney(int money){
        if (money < 1000){
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PROPER_MONEY);
        }
    }
}
