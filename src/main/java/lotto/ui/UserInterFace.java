package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class UserInterFace {
    public int inputInteger() {
        try {
            String input = Console.readLine();
            int result = Integer.valueOf(input);
            return result;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }
    }
}
