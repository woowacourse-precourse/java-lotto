package lotto.model.Issue;

import lotto.model.WinningNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbersIssueImpl implements WinningNumbersIssue{

    private final WinningNumbers winningNumbers;

    public WinningNumbersIssueImpl(String stringWinningNumbers, String stringBonusNumber){
        List<Integer> numbers = convertStringToNumbers(stringWinningNumbers);
        Integer bonusNumber = convertStringToNumber(stringBonusNumber);
        this.winningNumbers = new WinningNumbers(numbers,bonusNumber);
    }

    @Override
    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    private List<Integer> convertStringToNumbers(String systemInput) {
        List<Integer> numbers = Stream.of(systemInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateDuplicatedNumbers(numbers);
        return numbers;
    }

    private Integer convertStringToNumber(String systemInput) {
        return Integer.parseInt(systemInput);
    }

    private void validateDuplicatedNumbers(List<Integer> numbers){
        long count = numbers.stream().distinct().count();
        if (count != 6){
            throw new IllegalArgumentException();
        }
    }
}
