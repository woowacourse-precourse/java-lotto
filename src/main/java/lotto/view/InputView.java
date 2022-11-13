package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.List;

public class InputView {

    private static final String INPUT_NUMBER = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    Validator validator;

    public InputView() {
        validator = new Validator();
    }

    public int inputMoney() {
        System.out.println(INPUT_NUMBER);
        String money = Console.readLine();
        int moneyNumber = validator.moneyInputValidator(money);
        System.out.println();
        return moneyNumber;
    }

    public List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumbers = Console.readLine();
        return validator.winningNumberInputValidator(winningNumbers);
    }

    public int inputBonusNumber() {
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Validator.changeNumber(inputBonusNumber);
        validator.checkValidNumber(bonusNumber);
        return bonusNumber;
    }

}
