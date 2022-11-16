package lotto.Console;

import camp.nextstep.edu.missionutils.Console;

public class InputMessages {
    public String readLine() {
        return Console.readLine();
    }

    public String[] readLineAsArray() {
        return Console.readLine().split(",");
    }

    public InputMessages() {

    }
}
