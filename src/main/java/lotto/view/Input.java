package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputMoney() {
        return Console.readLine();
    }

    public static String inputJackpotNumber() {
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
