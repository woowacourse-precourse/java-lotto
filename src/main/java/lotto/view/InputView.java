package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IOMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {
    private InputView() {
    }

    public static int readAmount() {
        printMessage(IOMessage.READ_AMOUNT_MESSAGE);
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        printMessage(IOMessage.READ_WINNING_NUM_MESSAGE);
        String line = Console.readLine();
        // verify(line);
        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        printMessage(IOMessage.READ_BONUS_NUM_MESSAGE);
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    private static void printMessage(IOMessage message) {
        System.out.println(message.getMessage());
    }
}
