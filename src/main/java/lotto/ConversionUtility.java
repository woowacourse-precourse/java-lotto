package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionUtility {
    public List<Integer> convertStringWinningNumbersToList(String inputWinningNumbers) {
        return Arrays.asList(inputWinningNumbers.split(","))
                .stream().map(number -> Integer.parseInt(number)).collect(Collectors.toList());
    }
}
