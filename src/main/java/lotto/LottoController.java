package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class LottoController {

    public LottoController() {
        Validator validator = new Validator();
        String moneyInput = readLine();
        Integer money = validator.moneyValidate(moneyInput);
        User user = new User(money);
        String winningNumber = readLine();
        Lotto lotto = new Lotto(validator.winningNumberValidate(winningNumber));
    }
}
