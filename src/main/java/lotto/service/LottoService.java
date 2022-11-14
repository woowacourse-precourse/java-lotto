package lotto.service;

import lotto.domain.Purchaser;
import lotto.repository.PurchaserRepository;

import java.util.List;

public class LottoService {
    private final PurchaserRepository purchaserRepository;

    public LottoService() {
        purchaserRepository = new PurchaserRepository();
    }

    public Long generatePurchaser(int money) {
        Purchaser purchaser = new Purchaser(money);
        return purchaserRepository.insert(purchaser);
    }

    public void buyLotto(Long purchaserId) {
        Purchaser purchaser = purchaserRepository.findById(purchaserId);
        purchaser.generateLotto();
        purchaserRepository.save(purchaserId, purchaser);
    }

    public List<List<Integer>> findPurchaserLottos(Long purchaserId) {
        Purchaser purchaser = purchaserRepository.findById(purchaserId);
        return purchaser.getLottos();
    }
}