package lotto.vo;

import lotto.uility.vaildator.PurchaseValidator;

public class LottoPurchaseInfo extends PurchaseValidator {

    private final int LOTTO_PRICE = 1000;

    private final int lottoPrice;
    private final int lottoGameCount;

    public LottoPurchaseInfo(String lottoPrice) {
        validateInput(lottoPrice);
        int inputMoney = ConvertStringToInteger(lottoPrice);
        this.lottoPrice = inputMoney;
        this.lottoGameCount = inputMoney / LOTTO_PRICE;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getLottoGameCount() {
        return lottoGameCount;
    }

    private int ConvertMoneyStringToInteger(String money) {
        return Integer.parseInt(money);
    }




}
