package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.Error;

public class InputView {

    public static int getInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
        }
    }

    public static String getString() {
        return readLine();
    }

    public static List<Integer> getNumbers() {
        return Arrays.stream(readLine().split(",")).mapToInt(Integer::valueOf).boxed().collect(
                Collectors.toList());
    }
}
