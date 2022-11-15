package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.ErrorPrint;
import lotto.service.NumberChart;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputWinningNumber {

    public List<Integer> getAndVerifyNumber() {
        List<Integer> numbers = getWinningNumber();
        verifyBetween1and45(numbers);
        verifyDuplicateNumber(numbers);
        verifySixNumber(numbers);
        verifyNumber(numbers);

        return numbers;
    }

    private List<Integer> getWinningNumber() {
        return parseWinningNumber(Console.readLine());
    }

    private static List<Integer> parseWinningNumber(String winningNumber) {
        return Stream.of(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void verifyBetween1and45(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            if (!(NumberChart.MIN_NUMBER.getValue() <= number && number <= NumberChart.MAX_NUMBER.getValue())) {
                throw new IllegalArgumentException(ErrorPrint.ERROR_1_AND_45.getValue());
            }
        }
    }

    private void verifyDuplicateNumber(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == winningNumbers.stream().distinct().count())) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_WIN_DUPLICATE.getValue());
        }
    }

    private void verifySixNumber(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == NumberChart.LOTTO_SIZE.getValue())) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_WIN_SIX.getValue());
        }
    }

    private void verifyNumber(List<Integer> winningNumbers) {
        for (int number : winningNumbers) {
            String num = Integer.toString(number);
            if (!(num.matches(ErrorPrint.REGEX.getValue()))) {
                throw new IllegalArgumentException(ErrorPrint.ERROR_ONLY_NUMBER.getValue());
            }
        }
    }


}
