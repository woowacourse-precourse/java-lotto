package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSystem {
    List<Integer> winningNumbers;

    public LottoSystem() {
        winningNumbers = new ArrayList<>();
    }

    public void setWinningNumbers(String numbers) {
        validateWinningNumbers(numbers);
        winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinningNumbers(String input) {
        validateCount(input);
    }

    private void validateCount(String input) {
        if (input.split(",").length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 쉼표(,)로 구분하여 입력하세요.");
        }
    }
}
