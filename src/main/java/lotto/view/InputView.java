package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.exception.InputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InputView {
    private static final String PURCHASE_GREETING = "구입금액을 입력해 주세요.";

    private static final String INPUT_WinningNumber = "지난 주 당첨 번호를 입력해주세요";

    private static final String INPUT_BONUS = "보너스 볼을 입력해주세요";

    public static void startGuide() {
        System.out.println(PURCHASE_GREETING);
    }

    public static String inputMoney() {
        return Console.readLine();
    }

    public static List<String> inputWinningNumbers() {
        System.out.println(INPUT_WinningNumber);
        String winningString = Console.readLine();

        return Arrays.stream(split(winningString)).collect(Collectors.toList());
    }

    public static String inputBonus() {
        System.out.println(INPUT_BONUS);
        return Console.readLine();
    }

    private static String[] split(String winningString) {
        return winningString.split(",");
    }

}
