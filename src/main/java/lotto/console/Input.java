package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    private String readLine() {
        return Console.readLine().trim();
    }

    public int readInt() {
        return Integer.parseInt(readLine());
    }

    public List<Integer> readIntList() {
        String line = readLine();
        return InputParser.parseIntList(line, ",");
    }
}
