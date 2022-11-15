package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Error;

public class InputView {

    public static String input() {
        return readLine();
    }

    public static String getString() {
        return readLine();
    }

    public static List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(",")).mapToInt(Integer::valueOf).boxed().collect(
                Collectors.toList());
    }
}
