package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.lotto.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {

    private String readLine() {
        return Console.readLine().trim();
    }

    public int readInt() {
        return Integer.parseInt(readLine());
    }

    public List<Integer> readIntList() {
        String line = readLine();
        return InputParser.parseIntList(line, ", ");
    }
}
