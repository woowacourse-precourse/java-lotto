package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.CheckException;
import lotto.view.OutputView;

public class UserService {
    public static Integer getAmount() throws IllegalArgumentException {
        OutputView.printAmountInput();
        return CheckException.checkAmount(Console.readLine());
    }
}
