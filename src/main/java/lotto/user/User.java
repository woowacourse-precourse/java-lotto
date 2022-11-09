package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.user.validation.UserValidation;

public class User {
    public static int buyLotto() {
        String userAmount = Console.readLine();
        UserValidation.validate(userAmount);
        return Integer.parseInt(userAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        String userNumbers = Console.readLine();
        UserValidation.validateNumbers(userNumbers);
        return UserUtil.convertUserInputToNumbers(userNumbers);
    }
}
