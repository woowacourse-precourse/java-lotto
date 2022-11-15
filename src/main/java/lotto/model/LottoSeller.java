package lotto.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSeller(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public int calculateQuantity(PurchasePrice purchasePrice) {
        return purchasePrice.getPurchasePrice() / Lotto.PRICE;
    }

    public void sellLotteriesTo(Customer customer) {
        customer.buy(
                IntStream.range(0, calculateQuantity(customer.getPurchasePrice()))
                        .mapToObj((i) -> lottoNumberGenerator.generate())
                        .collect(Collectors.toList())
        );
    }
}
