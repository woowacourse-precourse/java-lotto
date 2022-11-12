package lotto.ui;


import lotto.entity.Bug;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class Input {
    public int inputAmount = 0;
    public List<Integer> winningNumbers = new ArrayList<>();
    public int bonusNumber;

    public int getAmount() {
        try {
            this.inputAmount = Integer.parseInt(Console.readLine());
            return this.inputAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage() + Bug.AMOUNT_MUST_NUMBER.getMessage());
        }
   }

    public List<Integer> getWinningNumbers() {
        List<String> beforeConversion = Arrays.asList(Console.readLine().split(","));
        try {
            this.winningNumbers = beforeConversion.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
            return this.winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage()
                    + Bug.LOTTO_NO_OTHER_INPUT.getMessage());
        }
    }

    public int getBonusNumber() {
        try {
            this.bonusNumber = Integer.parseInt(Console.readLine());
            return this.bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Bug.ERROR.getMessage() + Bug.BONUS_NO_OTHER_INPUT);
        }
    }

}
