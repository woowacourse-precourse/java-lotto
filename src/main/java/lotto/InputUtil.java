package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public int inputPurchasePrice(){
        String input = Console.readLine();
        return Integer.valueOf(input);
    }
}
