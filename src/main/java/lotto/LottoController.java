package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoController {

    public LottoController() {
        String moneyInput = Console.readLine();
        User user = new User(moneyInput);
    }
}
