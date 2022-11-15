package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static Integer receiveMoney() {
        String money = camp.nextstep.edu.missionutils.Console.readLine();
        return Integer.parseInt(money);
    }

    public static void receiveWinningNumbers(List<Integer> winningNumbers) {
        String input;
        input = camp.nextstep.edu.missionutils.Console.readLine();
        String[] numbers = input.split(",");
        for (String item : numbers) {
            winningNumbers.add(Integer.parseInt(item));
        }
        Judge.validateSize(winningNumbers);
        Judge.validateRange(winningNumbers);
    }

    public static void receiveBonusNumber(List<Integer> winningNumbers) {
        String number = camp.nextstep.edu.missionutils.Console.readLine();
        winningNumbers.add(Integer.parseInt(number));
        Judge.validateBonusSize(winningNumbers);
        Judge.validateBonusRange(winningNumbers);
    }

}
