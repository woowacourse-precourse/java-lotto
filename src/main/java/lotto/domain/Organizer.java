package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.constant.GameMessage;
import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;
import lotto.userinterface.Input;

public class Organizer {
    public List<Integer> winningNumbers;
    public int bonusNumber;

    public Organizer() {
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public void setWinningNumbersFromInput() {
        String winningNumberInput = Input.getInputWithMessage(GameMessage.ASK_FOR_WINNING_NUMBERS.getMessage());
        this.winningNumbers = transformStringToWinningNumbers(winningNumberInput);
        validateWinningNumbers(this.winningNumbers);
        ExceptionHandler.doesContainDuplicate(this.winningNumbers);
    }

    public void setBonusNumberFromInput() {
        String bonusNumberInput = Input.getInputWithMessage(GameMessage.ASK_FOR_BONUS_NUMBER.getMessage());
        this.bonusNumber = transformStringToInteger(bonusNumberInput);
        ExceptionHandler.isWithinRange(this.bonusNumber,
                LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
        checkDuplicate(this.winningNumbers, this.bonusNumber);
    }

    public List<Integer> transformStringToWinningNumbers(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String element : splitInput) {
            int number = transformStringToInteger(element);
            numbers.add(number);
        }
        return numbers;
    }

    private int transformStringToInteger(String input) {
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

    public void checkDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> combinedNumbers = new ArrayList<>(winningNumbers);
        combinedNumbers.add(bonusNumber);
        ExceptionHandler.doesContainDuplicate(combinedNumbers);
    }
}
