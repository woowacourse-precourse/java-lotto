package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {
    private InputView() {}

    public static int readAmount() {
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        String line = Console.readLine();
        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
