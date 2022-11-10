package lotto.console;

import camp.nextstep.edu.missionutils.Console;


public class Input {

    public static int inputMoney() {
        return Integer.parseInt(Console.readLine());
    }
    public static String[] inputLottoNumbers() {
        return Console.readLine().split(",");
    }
}
