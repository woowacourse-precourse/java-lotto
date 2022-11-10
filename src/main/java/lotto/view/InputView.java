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
        printMessage(READ_AMOUNT_MESSAGE);
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        String line = Console.readLine();
        printMessage(READ_WINNING_NUM_MESSAGE);
        // verify(line);
        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        printMessage(READ_BONUS_NUM_MESSAGE);
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    private static void printMessage(IOMessage message) {
        System.out.println(message.getMessage());
    }
}
