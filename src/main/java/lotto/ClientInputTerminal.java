package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ClientInputTerminal implements ClientInput {

    @Override
    public String get() {
        return Console.readLine();
    }
}
