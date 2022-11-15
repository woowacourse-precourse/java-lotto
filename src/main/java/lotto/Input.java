package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Input {
    public Lotto getWinningNumber(String line) throws IllegalArgumentException, NoSuchElementException { // WinningStatistics-valid-001
        try {
            List<Integer> winningNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber(String line) throws IllegalArgumentException, NoSuchElementException { // WinningStatistics-valid-002
        int bonusNumber = stringToInt(line);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public int getPayMoney(String line) throws IllegalArgumentException, NoSuchElementException { // Lotto-valid-001
        int payMoney = stringToInt(line);
        if (payMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return payMoney;
    }

    private int stringToInt(String line) { // Lotto-valid-001, WinningStatistics-valid-002
        int number = Integer.parseInt(line);
        return number;
    }
}
