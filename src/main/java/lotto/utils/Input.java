package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class Input {
    public static PurchaseAmount enterPurchaseAmount() {
        System.out.println(Notice.LOTTO_PURCHASE_AMOUNT.getMessage());
        String amount = Console.readLine();
        return new PurchaseAmount(amount);
    }

    public static WinningLotto enterWinningLotto() {
        System.out.println(Notice.ENTER_WINNING_NUMBER.getMessage());
        String winningNumbers = Console.readLine();
        return new WinningLotto(winningNumbers);
    }

    public static BonusNumber enterBonusNumber(WinningLotto winningLotto) {
        System.out.println(Notice.ENTER_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();
        return new BonusNumber(bonusNumber, winningLotto);
    }
}
