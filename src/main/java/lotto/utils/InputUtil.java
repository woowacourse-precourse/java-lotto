package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PurchaseAmountValidator;

public class InputUtil {

    public static int purchaseAmount() {
        String money = Console.readLine();
        PurchaseAmountValidator.validate(money);
        return Integer.parseInt(money);
    }

    public static void lottoNumber() {
        String lottoNumber = Console.readLine();
        LottoNumberValidator.validate(lottoNumber);
    }
}
