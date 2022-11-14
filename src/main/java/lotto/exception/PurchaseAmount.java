package lotto.exception;

public class PurchaseAmount extends CommonException {

    private static void checkInTheThousands(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_IN_THE_THOUSANDS.getMessage());
        }
    }
}
