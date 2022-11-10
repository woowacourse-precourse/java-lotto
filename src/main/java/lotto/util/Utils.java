package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class Utils {
    public static int stringToIntMoney(String money) {
        return Integer.parseInt(money);
    }

    public static String readConsole() {
        return Console.readLine();
    }
}
