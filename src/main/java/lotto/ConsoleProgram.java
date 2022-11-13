package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class ConsoleProgram {

    public int requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        validate(userInput);
        return Integer.parseInt(userInput);
    }

    private void validate(String userInput) {
        Validator.checkNumber(userInput);
        Validator.checkMoney(userInput);
    }
}
