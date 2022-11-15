package lotto.ui;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public int getUserMoney() {
        try {
            int money = Integer.parseInt(Console.readLine());
            return money;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Ouput.INVAILD_INPUT_VALUE_ERROR);
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        try {
            String csv = Console.readLine();
            String[] numbers = csv.split(",");
            for (int ordinal = 0; ordinal < numbers.length; ordinal++) {
                winningNumbers.add(Integer.parseInt(numbers[ordinal]));
            }
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Ouput.INVAILD_INPUT_VALUE_ERROR);
        }
    }

    public int getBonusNumber() {
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Ouput.INVAILD_INPUT_VALUE_ERROR);
        }
    }
}
