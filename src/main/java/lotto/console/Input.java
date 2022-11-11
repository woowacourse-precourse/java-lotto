package lotto.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Input {

    private String readLine() {
        return Console.readLine().trim();
    }

    public int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public List<Integer> readIntList() {
        String line = readLine();
        return InputParser.parseIntList(line, ",");
    }
}
