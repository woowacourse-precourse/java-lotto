package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.validation.LottoNumbersValidation;

public class User {
    public static String buyLotto() {
        String userAmount = Console.readLine();
        return userAmount;
    }

    public static List<Integer> inputLottoNumbers() {
        String userNumbers = Console.readLine();
        LottoNumbersValidation.validateInputLottoNumbers(userNumbers);
        return UserUtil.convertUserInputToNumbers(userNumbers);
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
