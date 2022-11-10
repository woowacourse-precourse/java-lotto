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
        IOMessage.READ_AMOUNT_MESSAGE.printMessage();
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        IOMessage.READ_WINNING_NUM_MESSAGE.printMessage();
        String line = Console.readLine();
        // verify(line);
        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        IOMessage.READ_BONUS_NUM_MESSAGE.printMessage();
        String line = Console.readLine();
        // verify(line);
        return Integer.parseInt(line);
    }
}
