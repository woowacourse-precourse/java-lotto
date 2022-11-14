package lotto.view;

import static lotto.util.Message.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;
import java.util.List;

public class InputView {
    private static final Validator validator = new Validator();

    public int inputMoney(){
        System.out.println(LOTTO_START);
        String input = Console.readLine();
        validator.moneyValid(input);
        return Integer.parseInt(input);
    }
}
