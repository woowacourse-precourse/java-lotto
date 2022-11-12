package lotto.model;

import java.util.List;
import java.util.ArrayList;

public class WinningNumber {
    private List<Integer> numbers = new ArrayList<>();
    private int bonusNumber;

    public WinningNumber(String numbers) {
        stringToNumbers(numbers);
    }

    private void stringToNumbers(String numbers) {
        String[] stringNumbers = numbers.split(",");
        for (String number: stringNumbers) {
            this.numbers.add(Integer.valueOf(number));
        }
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
