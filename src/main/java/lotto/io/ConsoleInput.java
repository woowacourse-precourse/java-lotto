package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {

    @Override
    public String getUserInput() {
        return Console.readLine();
    }
}
