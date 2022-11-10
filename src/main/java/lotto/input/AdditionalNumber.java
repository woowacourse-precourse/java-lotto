package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class AdditionalNumber {
    public int getBonus() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}