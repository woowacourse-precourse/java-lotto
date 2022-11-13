package lotto.service;

import lotto.domain.Purchaser;
import lotto.repository.PurchaserRepository;

public class LottoService {
    private final PurchaserRepository purchaserRepository;

    public LottoService() {
        purchaserRepository = new PurchaserRepository();
    }

    public Long generatePurchaser(int money) {
        Purchaser purchaser = new Purchaser(money);
        return purchaserRepository.insert(purchaser);
    }

}