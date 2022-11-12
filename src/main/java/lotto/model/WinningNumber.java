package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class WinningNumber {
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public WinningNumber(String numbers) {
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public List<Integer> getWinningNumber() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
