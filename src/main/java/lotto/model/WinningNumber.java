package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WinningNumber {

    private int[] inputWinningNumbers;
    private int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int[] getWinningNumbers() {
        return inputWinningNumbers;
    }

    public void setWinningNumbers(String winningNumber) {
        this.inputWinningNumbers = Arrays.stream(winningNumber.split(","))
            .mapToInt(Integer::parseInt).sorted()
            .toArray();
    }
}
