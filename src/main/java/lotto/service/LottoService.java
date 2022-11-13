package lotto.service;

import lotto.repository.PurchaserRepository;

public class LottoService {
    private final PurchaserRepository purchaserRepository;

    public LottoService() {
        purchaserRepository = new PurchaserRepository();
    }

    public Long generatePurchaser() {
        return purchaserRepository.insertPurchaser();
    }
}