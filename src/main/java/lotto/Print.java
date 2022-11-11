package lotto;

import java.util.List;

public class Print {
    public static void purchaseMessage() {
        System.out.println(GuideMessage.ENTER_PURCHASE_AMOUNT);
    }

    public static void lottery(List<Lotto> lottery) {
        System.out.println(lottery.size() + GuideMessage.CONFIRM_PURCHASE_AMOUNT);

        for (Lotto lotto : lottery) {
            lotto.print();
        }

        System.out.println();
    }

    public static void enterWinningNumberMessage() {
        System.out.println(GuideMessage.ENTER_WINNING_NUMBER);
    }

    public static void enterBonusNumberMessage() {
        System.out.println(GuideMessage.ENTER_BONUS_NUMBER);
    }
}
