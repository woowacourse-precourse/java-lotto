package lotto.user;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.validation.LottoBonusValidation;
import lotto.domain.validation.LottoNumbersValidation;
import lotto.user.validation.UserMoneyValidation;

public class User {
    public static int buyLotto() {
        String userAmount = Console.readLine();
        UserMoneyValidation.validate(userAmount);
        return Integer.parseInt(userAmount);
    }

    public static List<Integer> inputLottoNumbers() {
        String userNumbers = Console.readLine();
        LottoNumbersValidation.validateInputLottoNumbers(userNumbers);
        List<Integer> lottoNumbers = UserUtil.convertUserInputToNumbers(userNumbers);
        LottoNumbersValidation.validateLottoNumbers(lottoNumbers);
        return lottoNumbers;
    }

    public static Integer inputBonusNumber() {
        String userNumbers = Console.readLine();
        LottoBonusValidation.validate(userNumbers);
        return Integer.valueOf(userNumbers);
    }
}
