package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public Lotto getWinningNumber(String line) { // WinningStatistics-valid-001
        try {
            List<Integer> winningNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public int validBonusNumber(String line) { // WinningStatistics-valid-002
        int bonusNumber = stringToInt(line);
        if (bonusNumber < 1 || bonusNumber > 45) {
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public int getPayMoney(String line) { // Lotto-valid-001
        int payMoney = stringToInt(line);
        if (payMoney % 1000 != 0) {
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
        return payMoney;
    }

    private int stringToInt(String line) { // Lotto-valid-001, WinningStatistics-valid-002
        try {
            int number = Integer.parseInt(line);
            return number;
        } catch (NumberFormatException e) {
            System.out.println(Message.ILLEGAL_ARGUMENT_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
