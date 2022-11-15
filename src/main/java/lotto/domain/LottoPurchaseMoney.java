package lotto.domain;

import static lotto.constants.ErrorConstant.ERR_MONEY_MORE_THAN_A_LOTTO_PRICE;
import static lotto.constants.ErrorConstant.ERR_MONEY_UNFIT_A_LOTTO_PRICE;
import static lotto.constants.LottoConstant.A_LOTTO_PRICE;

public class LottoPurchaseMoney {

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
