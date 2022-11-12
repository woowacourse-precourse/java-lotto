package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.InputValidator;

public class InputView {

    InputValidator inputValidator = new InputValidator();

    public void readInput() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = Console.readLine();

        inputValidator.validate(input);
        
    }
}
