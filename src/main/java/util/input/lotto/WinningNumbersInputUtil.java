package util.input.lotto;

import static java.util.stream.Collectors.toList;
import static lotto.Message.INPUT_WINNING_NUMBERS;
import static util.input.global.InputUtil.getInputs;

import java.util.List;
import lotto.Lotto;
import validation.Validator;

public class WinningNumbersInputUtil {
    public static Lotto getWinningNumbers() {
        printMessage();

        List<Integer> numbers = getNumbers();

        return new Lotto(numbers);
    }

    private static void printMessage() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
    }

    private static List<Integer> getNumbers() {
        List<String> inputs = getInputs();

        System.out.println();

        validate(inputs);

        List<Integer> numbers = toInteger(inputs);

        return numbers;
    }

    private static void validate(List<String> inputs) {
        Validator validator = new Validator();

        validator.validateWinningNumbers(inputs);
    }

    private static List<Integer> toInteger(List<String> inputs) {
        return inputs.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }
}
