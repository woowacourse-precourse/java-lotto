package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static int getInt() {
        return Integer.parseInt(readLine());
    }

    public static String getString() {
        return readLine();
    }

    public static List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(",")).mapToInt(Integer::valueOf).boxed().collect(
                Collectors.toList());
    }
}
