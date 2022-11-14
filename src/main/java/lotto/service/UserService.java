package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutputView;

public class UserService {
    public static Integer getAmount() {
        OutputView.printAmountInput();
        return Integer.parseInt(Console.readLine());
    }
}
