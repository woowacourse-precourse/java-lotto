package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputManager {

    ExceptionManager exceptionManager = new ExceptionManager();

    public int inputMoney() {
        int playerMoney;
        System.out.println("구입 금액을 입력해주세요.");
        String stringPlayerMoney = Console.readLine();
        exceptionManager.checkPlayerMoney(stringPlayerMoney);
        playerMoney = Integer.parseInt(stringPlayerMoney);
        return playerMoney;
    }

    public List<String> inputWinningNumbers() {
        System.out.print("\n당첨 번호를 입력해주세요.\n");
        String numbers = Console.readLine();
        List<String> winningNumbers = Stream.of(numbers.split("\\s*,\\s*"))
                .collect(Collectors.toList());
        exceptionManager.checkWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public String inputBonusNumber(List<Integer> winningNumbers) {
        System.out.print("\n보너스 번호를 입력해 주세요.\n");
        String bonusNumber = Console.readLine();
        exceptionManager.checkBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}
