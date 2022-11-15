package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    private InputUtils() {
    }

    public static InputUtils getInstance() {
        return new InputUtils();
    }


    public List<Integer> convertToWinningNumbers(String winningNumbersInput) {
        String[] splitInput = winningNumbersInput.split(",");
        List<Integer> winningNumbers = Arrays.stream(splitInput)
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());
        return winningNumbers;
    }
}
