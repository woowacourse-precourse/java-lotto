package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

import java.util.List;

public class InputView {

    private static final String INPUT_NUMBER = "구입금액을 입력해 주세요.";
    Validator validator;

    public InputView(){
        validator = new Validator();
    }

    public int inputMoney() {
        System.out.println(INPUT_NUMBER);
        String money = Console.readLine();
        int moneyNumber = validator.moneyInputValidator(money);
        return moneyNumber;
    }

    public List<Integer> inputWinningNumber() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    public int inputBonusNumber() {
        return 1;
    }

}
