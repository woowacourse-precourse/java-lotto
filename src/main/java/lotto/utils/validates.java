package lotto.utils;

public class validates {
    private boolean validatePurchaseMoney(int purchaseMoney) {
        if(purchaseMoney % 1000 != 0)return false;
        return true;
    }

    private boolean validateLottoCount() {
        return true;
    }

    private boolean validateLottoBound() {
        return true;
    }

}
