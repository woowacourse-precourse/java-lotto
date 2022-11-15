package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaser {
    private final int purchaseAmount;

    public LottoPurchaser() {
        purchaseAmount = purchase();
    }

    private int purchase() {
        System.out.println(Message.PURCHASE_AMOUNT_REQUEST);

        String purchaseAmountInput = Console.readLine();

        return validate(purchaseAmountInput);
    }

    private int validate(String purchaseAmountInput) {
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);

            if (purchaseAmount % LottoGenerator.LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(String.format("[ERROR] 구입금액은 %d원 단위여야 합니다.", LottoGenerator.LOTTO_PRICE));
            }

            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
