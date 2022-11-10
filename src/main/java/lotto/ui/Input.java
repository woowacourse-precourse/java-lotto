package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.Bug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public int inputAmount = 0;
    public List<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;

    public void getInputAmount() {
        try {
            this.inputAmount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                    (Bug.ERROR.getMessage() + Bug.AMOUNT_MUST_NUMBER.getMessage());
        }
    }

    public void getWinningNumbers() {
        List<String> beforeConversion = Arrays.asList(Console.readLine().split(","));
        try {
            this.winningNumbers = beforeConversion.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                    (Bug.ERROR.getMessage() + Bug.LOTTO_NO_OTHER_INPUT.getMessage());
        }
    }

    public void getBonusNumber() {
        try {
            this.bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException
                    (Bug.ERROR.getMessage() + Bug.BONUS_NO_OTHER_INPUT);
        }
    }

}
