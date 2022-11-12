package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String CRITERION_SPLIT = ",";

    public static int inputPurchasePrice() {
        return inputOneNumber();
    }

    private static int inputOneNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputAnswerNumbers() {
        String answerNumbers = Console.readLine();
        String[] splitAnswerNumbers = answerNumbers.split(CRITERION_SPLIT);
        return mapToInteger(splitAnswerNumbers);
    }

    private static List<Integer> mapToInteger(String[] split) {
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        return inputOneNumber();
    }
}
