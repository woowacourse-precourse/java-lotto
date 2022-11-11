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
    }

    public List<Integer> getWinningNumbersFromInput(String input) {
        List<String> splitInput = List.of(input.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String element : splitInput) {
            ExceptionHandler.isStringNumeric(element);
            int number = Integer.parseInt(element);
            ExceptionHandler.isWithinRange(number,
                    LottoStatistic.MIN_NUMBER.getValue(), LottoStatistic.MAX_NUMBER.getValue());
            numbers.add(number);
        }
        ExceptionHandler.isListCorrectSize(numbers, LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        return numbers;
    }
}
