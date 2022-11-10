package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.user.validation.UserBonusValidation;
import lotto.user.validation.UserNumbersValidation;
import lotto.user.validation.UserMoneyValidation;

public class User {
    public static int buyLotto() {
        String userAmount = Console.readLine();
        UserMoneyValidation.validate(userAmount);
        return Integer.parseInt(userAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        String userNumbers = Console.readLine();
        UserNumbersValidation.validate(userNumbers);
        return UserUtil.convertUserInputToNumbers(userNumbers);
    }

    public static Integer inputBonusNumber() {
        String userNumbers = Console.readLine();
        UserBonusValidation.validate(userNumbers);
        return Integer.valueOf(userNumbers);
    }
}
