package lotto.view;

import static lotto.util.Util.removeSpace;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static String inputCash() {
        OutputView.printCashInput();
        return getInput();
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.printWinningNumberInput();
        return formatInput(getInput());
    }

    public static String inputBonusNumber() {
        OutputView.printBonusNumberInput();
        return getInput();
    }

    private static String getInput() {
        return Console.readLine();
    }

    private static List<Integer> formatInput(String input) {
        return convertStringListToIntList(separateStringByComma(removeSpace(input)));
    }

    private static List<String> separateStringByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static List<Integer> convertStringListToIntList(List<String> list) {
        return list.stream().map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
