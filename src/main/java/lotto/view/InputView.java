package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {}

    public static int readAmount() {
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }
}
