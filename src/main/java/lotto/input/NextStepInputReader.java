package lotto.input;

import camp.nextstep.edu.missionutils.Console;

public class NextStepInputReader implements InputReader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
