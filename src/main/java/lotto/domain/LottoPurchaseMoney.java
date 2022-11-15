package lotto.domain;

public class LottoPurchaseMoney {

    private static final int A_LOTTO_PRICE = 1000;
    private static final String ERR_MONEY_MORE_THAN_A_LOTTO_PRICE = "[ERROR] 로또 구매 금액은 최소 1000원 이상이어야 합니다. ";
    private static final String ERR_MONEY_UNFIT_A_LOTTO_PRICE = "[ERROR] 로또 구매 금액은 1000원 단위여야 합니다. ";

    private int lottoPurchaseMoney;

    public LottoPurchaseMoney(int lottoPurchaseMoney) {
        validateLottoPurchaseMoney(lottoPurchaseMoney);
        this.lottoPurchaseMoney = lottoPurchaseMoney;
    }

    private void validateLottoPurchaseMoney(int lottoPurchaseMoney) {
        validateMoneyMoreThanLottoPrice(lottoPurchaseMoney);
        validateMoneyIsMultipleLottoPrice(lottoPurchaseMoney);
    }

    private void validateMoneyMoreThanLottoPrice(int lottoPurchaseMoney) {
        if (lottoPurchaseMoney < A_LOTTO_PRICE) {
            throw new IllegalArgumentException(ERR_MONEY_MORE_THAN_A_LOTTO_PRICE);
        }
    }

    private void validateMoneyIsMultipleLottoPrice(int lottoPurchaseMoney) {
        if (lottoPurchaseMoney % A_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERR_MONEY_UNFIT_A_LOTTO_PRICE);
        }
    }

    public int get() {
        return lottoPurchaseMoney;
    }
}
