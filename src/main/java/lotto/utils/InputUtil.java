package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.InputLottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

import java.util.List;

public class InputUtil {

    public static int readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        PurchaseAmountValidator.validate(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public static List<Integer> readWinningLottoNumber() {
        String winningLottoNumber = Console.readLine();
        InputLottoNumberValidator.validate(winningLottoNumber);
        return FormatLottoNumber.get(winningLottoNumber);
    }

    public static Integer readBonusNumber(Lotto winLotto) {
        String bonusNumber = Console.readLine();
        BonusNumberValidator.validate(bonusNumber, winLotto);
        return Integer.parseInt(bonusNumber);
    }
}
