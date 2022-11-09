package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import lotto.user.validation.UserValidation;

public class User {
    public static int buyLotto() {
        String userAmount = Console.readLine();
        UserValidation.validate(userAmount);
        return Integer.parseInt(userAmount);
    }
}
