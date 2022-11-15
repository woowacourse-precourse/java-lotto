package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoSystem {
    private WinningNumber winningNumber;

    public void setWinningNumbers(String numbers) throws IllegalArgumentException {
        numbers = numbers.replaceAll("\\s", "");
        validateWinningNumbers(numbers);
        List<Integer> winningNumbers = stringArrayToIntegerList(numbers.split(","));
        winningNumber = new WinningNumber(winningNumbers);
    }

    public void setBonusNumber(String number) {
        validateType(number);
        if (winningNumber == null) {
            return;
        }
        winningNumber.setBonusNumber(Integer.parseInt(number));
    }

    public LottoStatistics getWinningStatistics(List<Lotto> lottoBundle) {
        LottoStatistics statistics = new LottoStatistics(lottoBundle, winningNumber);
        return statistics;
    }

    private void validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        validateType(numbers);
    }

    private void validateType(String[] numbers) {
        for (String number : numbers) {
            validateType(number);
        }
    }

    private void validateType(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private List<Integer> stringArrayToIntegerList(String[] array) {
        List<Integer> result = Arrays.stream(array)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;
    }
}
