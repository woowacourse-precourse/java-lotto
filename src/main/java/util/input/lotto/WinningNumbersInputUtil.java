package util.input.lotto;

import static java.util.stream.Collectors.toList;
import static util.input.global.InputUtil.getInputs;

import java.util.List;
import lotto.Lotto;

public class WinningNumbersInputUtil {
    public static Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> numbers = getNumbers();

        return new Lotto(numbers);
    }

    private static List<Integer> getNumbers() {
        List<String> inputs = getInputs();

        System.out.println();

        List<Integer> numbers = toInteger(inputs);

        return numbers;
    }

    private static List<Integer> toInteger(List<String> inputs) {
        return inputs.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }
}
