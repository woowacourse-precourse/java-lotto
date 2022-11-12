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

    public void setWinningNumbers(String winningNumberInput) {
        this.winningNumbers = getWinningNumbersFromInput(winningNumberInput);
        validateWinningNumbers(this.winningNumbers);
        ExceptionHandler.doesContainDuplicate(this.winningNumbers);
    }

    public void setBonusNumber(String bonusNumberInput) {
        this.bonusNumber = getIntegerFromString(bonusNumberInput);
        ExceptionHandler.isWithinRange(this.bonusNumber,
                LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        checkDuplicate(this.winningNumbers, this.bonusNumber);
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
        String trimmedInput = input.trim();
        ExceptionHandler.isStringNumeric(trimmedInput);
        return Integer.parseInt(trimmedInput);
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
