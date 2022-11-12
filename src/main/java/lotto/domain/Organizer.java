package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;

public class Organizer {
    public List<Integer> winningNumbers;
    public int bonusNumber;

    public Organizer() {
    }

    public Organizer(String winningNumberInput, String bonusNumberInput) {
        this.winningNumbers = getWinningNumbersFromInput(winningNumberInput);
        validateWinningNumbers(this.winningNumbers);
        this.bonusNumber = getIntegerFromString(bonusNumberInput);
        ExceptionHandler.isWithinRange(bonusNumber,
                LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        checkDuplicate(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbersFromInput(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String element : splitInput) {
            int number = getIntegerFromString(element);
            numbers.add(number);
        }
        return numbers;
    }

    private int getIntegerFromString(String input) {
        ExceptionHandler.isStringNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        ExceptionHandler.isListCorrectSize(winningNumbers, LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        for (int number : winningNumbers) {
            ExceptionHandler.isWithinRange(number,
                    LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        }
    }

    private void checkDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> combinedNumbers = new ArrayList<>(winningNumbers);
        combinedNumbers.add(bonusNumber);
        ExceptionHandler.doesContainDuplicate(combinedNumbers);
    }
}
