package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String CRITERION_SPLIT = ",";
    public static final String ERROR_INVALID_INPUT_NUMBER = "[ERROR] 입력 값은 숫자만 가능합니다.";
    public static final String ERROR_INVALID_ANSWER_NUMBERS = "[ERROR] 잘못 된 형식의 로또 번호 입력 값입니다.";

    public static int inputPurchasePrice() {
        return inputOneNumber();
    }

    private static int inputOneNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT_NUMBER);
        }
    }

    public static List<Integer> inputAnswerNumbers() {
        try {
            String answerNumbers = Console.readLine();
            String[] splitAnswerNumbers = answerNumbers.split(CRITERION_SPLIT);
            return mapToInteger(splitAnswerNumbers);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ERROR_INVALID_ANSWER_NUMBERS);
        }
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
