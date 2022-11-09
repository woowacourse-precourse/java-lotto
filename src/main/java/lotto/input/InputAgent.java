package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.ValueValidator;

public class InputAgent {

    public int inputUserMoney() {
        String lottoPurchaseMoney = Console.readLine();
        ValueValidator.validateLottoPurchaseMoney(lottoPurchaseMoney);
        return Integer.parseInt(lottoPurchaseMoney);
    }

    public String[] inputLottoNumbers() {
        return Console.readLine().split(",");
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
