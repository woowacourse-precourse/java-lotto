package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.constants.Comment;
import lotto.utils.constants.LottoConstant;
import lotto.utils.iosupport.LottoPrinter;
import lotto.utils.validator.UserMoneyValidator;

public class LottoManager {

    public void run() {
        long purchaseAmount = processPurchase();
    }

    private long processPurchase() {
        long purchaseAmount = getPurchaseAmount();
        LottoPrinter.printPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public long getPurchaseAmount() throws IllegalArgumentException {
        System.out.println(Comment.INPUT_AMOUNT.getComment());
        String purchaseMoney = Console.readLine();

        UserMoneyValidator.validate(purchaseMoney);
        return Long.parseLong(purchaseMoney) / LottoConstant.LOTTO_AMOUNT_UNIT.getNumber();
    }
}
