package lotto.validate;

public class BuyerValidate {
    public void validate(int buyPrice, int lottoPrice) {
        priceUnitValidate(buyPrice, lottoPrice);
        priceIsPlus(buyPrice);
    }

    private void priceUnitValidate(int buyPrice, int lottoPrice) {
        if (buyPrice % lottoPrice != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액이 올바르지 않습니다.");
        }
    }

    private void priceIsPlus(int buyPrice) {
        if (buyPrice < 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액이 0보다 작습니다.");
        }
    }
}
