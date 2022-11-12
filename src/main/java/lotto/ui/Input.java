package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int getUserMoney() {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.INVAILD_INPUT_VALUE);
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String numbers = Console.readLine();
            String[] a = numbers.split(",");
            for (int i = 0; i < a.length; i++) {
                winningNumbers.add(Integer.parseInt(a[i]));
            }
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.INVAILD_INPUT_VALUE);
        }
    }

    public int getBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Error.INVAILD_INPUT_VALUE);
        }
    }
}
