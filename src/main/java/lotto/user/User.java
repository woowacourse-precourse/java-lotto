package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.GameMessage;
import lotto.domain.validation.LottoNumbersValidation;

public class User {
    public static String buyLotto() {
        System.out.println(GameMessage.BUY);
        return Console.readLine();
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println(GameMessage.INPUT_NUMBERS);
        String userNumbers = Console.readLine();
        LottoNumbersValidation.validateInputLottoNumbers(userNumbers);
        return UserUtil.convertUserInputToNumbers(userNumbers);
    }

    public static String inputBonusNumber() {
        System.out.println(GameMessage.INPUT_BONUS);
        return Console.readLine();
    }
}
