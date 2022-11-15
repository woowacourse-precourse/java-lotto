package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.BonusNumber;
import lotto.Lotto;
import lotto.PurchaseMoney;

public class UserInputView {
    static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    static final String INPUT_BONUS = "보너스 번호를 입력해 주세요";
    static final String ERROR_MESSAGE_FOR_PURCHASE_PRICE_IS_NUMBER = "구매하시는 금액은 숫자만 입력하셔야 합니다.";

    public static PurchaseMoney getPurchaseMoney() {
        System.out.println(INPUT_MONEY);
        String purchaseMoney = Console.readLine();
        try {
            return new PurchaseMoney(Integer.parseInt(purchaseMoney));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_PURCHASE_PRICE_IS_NUMBER);
        }
    }

    public static Lotto getWinningLottoNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        String winNumber = Console.readLine();
        return new Lotto(winNumber);
    }

    public static BonusNumber getBonusLottoNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS);
        String bonusNumber = Console.readLine();
        System.out.println();
        return new BonusNumber(bonusNumber);
    }
}
