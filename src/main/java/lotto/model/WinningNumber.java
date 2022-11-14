package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumber) {
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setWinningNumbers(String winningNumber) {
        this.winningNumbers = Arrays.stream(Arrays.stream(winningNumber.split(","))
            .mapToInt(Integer::parseInt).sorted()
            .toArray()).boxed().collect(Collectors.toList());
    }
}
