package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public static Integer receiveMoney() {
        String money = camp.nextstep.edu.missionutils.Console.readLine();
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아닌 문자가 입력되었습니다.");
        }
    }

    public static void receiveWinningNumbers(List<Integer> winningNumbers) {
        String input;
        input = camp.nextstep.edu.missionutils.Console.readLine();
        String[] numbers = input.split(",");
        for (String item : numbers) {
            try {
                winningNumbers.add(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 , 로 구분하여 입력하십시오.");
            }
        }
        Judge.validateSize(winningNumbers);
        Judge.validateRange(winningNumbers);
        Judge.checkRedundancy(winningNumbers);
    }

    public static void receiveBonusNumber(List<Integer> winningNumbers) {
        String number = camp.nextstep.edu.missionutils.Console.readLine();
        winningNumbers.add(Integer.parseInt(number));
        Judge.validateBonusSize(winningNumbers);
        Judge.validateBonusRange(winningNumbers);
        Judge.checkRedundancy(winningNumbers);
    }

}
