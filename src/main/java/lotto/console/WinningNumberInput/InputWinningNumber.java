package lotto.console.WinningNumberInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.chart.NumberChart;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputWinningNumber {

    public List<Integer> getAndVerifyNumber() {
        List<Integer> numbers = getWinningNumber();
        verifyBetween1and45(numbers);
        verifyDuplicateNumber(numbers);
        verifySixNumber(numbers);

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
                throw new RuntimeException("[ERROR] 1 ~ 45 사이의 숫자만 입력해 주세요");
            }
        }
    }

    private void verifyDuplicateNumber(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == winningNumbers.stream().distinct().count())) {
            throw new RuntimeException("[ERROR] 중복인 숫자가 있습니다.");
        }
    }

    private void verifySixNumber(List<Integer> winningNumbers) {
        if (!(winningNumbers.size() == NumberChart.LOTTO_SIZE.getValue())) {
            throw new RuntimeException("[ERROR] 6개의 숫자를 입력하세여");
        }
    }


}
