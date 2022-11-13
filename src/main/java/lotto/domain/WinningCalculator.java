package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningCalculator {
    private List<Integer> numbers;
    private int bonusNumber;

    public void setWinningNumbers(String numbersRaw) {
        List<Integer> winningNumbers = convertStringToIntegerList(numbersRaw);
        numbers = winningNumbers;
    }

    public void setBonusNumber(String bonusNumberRaw) {
        int bonusNumberConverted = Integer.parseInt(bonusNumberRaw);
        bonusNumber = bonusNumberConverted;
    }

    private List<Integer> convertStringToIntegerList(String numbersRaw) {
        List<Integer> numbersConverted = Arrays.asList(numbersRaw.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbersConverted;
    }
}
