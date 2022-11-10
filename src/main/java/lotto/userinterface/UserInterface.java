package lotto.userinterface;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    private static final Integer UNIT = 1000;

    private UserInterface() {
    }

    public static Integer getMoney() {
        String input = getInput();

        if (isNotDividedWithUnit(input)) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

    private static boolean isNotDividedWithUnit(String input) {
        return Integer.parseInt(input) % UNIT != 0;
    }

    private static String getInput() {
        return Console.readLine();
    }
}
