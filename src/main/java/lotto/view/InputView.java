package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IOMessage;
import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.MoneyVerifier;
import lotto.verifier.WinnerNumberVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {
    private static MoneyVerifier moneyVerifier = new MoneyVerifier();
    private static BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();
    private static WinnerNumberVerifier winnerNumberVerifier = new WinnerNumberVerifier();

    private InputView() {
    }

    public static int readAmount() {
        printMessage(IOMessage.READ_AMOUNT_MESSAGE);
        String line = Console.readLine();
        moneyVerifier.check(line);

        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        printMessage(IOMessage.READ_WINNING_NUM_MESSAGE);
        String line = Console.readLine();
        winnerNumberVerifier.check(line);

        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        printMessage(IOMessage.READ_BONUS_NUM_MESSAGE);
        String line = Console.readLine();
        bonusNumberVerifier.check(line);
        
        return Integer.parseInt(line);
    }

    private static void printMessage(IOMessage message) {
        System.out.println(message.getMessage());
    }
}
