package lotto.console;

import static lotto.console.InputParser.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    private String readLine() {
        return Console.readLine().trim();
    }

    public int readInt() {
        return parseNumber(readLine());
    }

    public List<Integer> readStandardWinningNumbers() {
        String line = readLine();
        return parseStandardWinningNumbers(line);
    }
}
