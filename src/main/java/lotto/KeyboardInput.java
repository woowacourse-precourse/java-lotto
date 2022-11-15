package lotto;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardInput {
    public static String read() {
        return Console.readLine();
    }

    public static String[] readArray() {
        return read().split(",");
    }
}
