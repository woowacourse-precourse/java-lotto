package lotto.model;

public class LottoSeller {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSeller(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int calculateQuantity(PurchasePrice purchasePrice) {
        return purchasePrice.getPrice() / Lotto.PRICE;
    }
}
