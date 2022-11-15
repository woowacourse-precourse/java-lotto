package lotto.winningNumbersGenerator;

import lotto.numbers.WinningNumbers;
import lotto.numbers.WinningNumbersImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ExceptionMessage.NOT_INTEGER;
import static lotto.constants.ExceptionMessage.NULL_POINTER;

public class WinningNumbersGeneratorImpl implements WinningNumbersGenerator{
    @Override
    public WinningNumbers generateWinningNumbers(String mainNumbers, String bonusNumber) {
        List<Integer> convertedMainNumbers = convertToIntegerList(mainNumbers);
        int convertedBonusNumber = convertToInteger(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbersImpl(convertedMainNumbers, convertedBonusNumber);
        return winningNumbers;
    }

    private List<Integer> convertToIntegerList(String mainNumbers) {
        if(mainNumbers == null || mainNumbers.length() == 0) {
            throw new IllegalArgumentException(NULL_POINTER);
        }

        String[] numbersArr = mainNumbers.split(",");

        List<Integer> convertedNumbers;
        try {
            convertedNumbers = Arrays.stream(numbersArr)
                    .map(str -> Integer.parseInt(str))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        return convertedNumbers;
    }

    private int convertToInteger(String bonusNumber) {
        int num = 0;
        try {
            num = Integer.parseInt(bonusNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
        return num;
    }
}
