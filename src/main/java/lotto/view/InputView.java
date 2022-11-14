package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InputValidator;


public class InputView {

    private final InputValidator validator = new InputValidator();

    public int sendMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        validator.validateMoney(money);

        return Integer.parseInt(money);
    }

    public List<Integer> sendWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        validator.validateWinningNumbers(winningNumbers);

        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int sendBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validator.validateBonusNumber(bonusNumber, winningNumbers);

        return Integer.parseInt(bonusNumber);
    }
}
