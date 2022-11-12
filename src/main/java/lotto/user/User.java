package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.validation.LottoNumbersValidation;

public class User {
    private static final String COMMA = ",";

    public static String buyLotto() {
        String userAmount = Console.readLine();
        return userAmount;
    }

    public static String inputLottoNumbers() {
        String userNumbers = Console.readLine();
        LottoNumbersValidation.validateInputLottoNumbers(userNumbers);
        return userNumbers;
    }

    public static String inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }
}
