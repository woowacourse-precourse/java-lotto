package lotto.repository;

import lotto.domain.Purchaser;

import java.util.HashMap;
import java.util.Map;

public class PurchaserRepository {
    private Long id = 0L;
    private final Map<Long, Purchaser> repository = new HashMap<>();

    public Long insertPurchaser() {
        Long purchaserId = id;
        repository.put(purchaserId, new Purchaser());
        incrementId();
        return purchaserId;
    }

    private void incrementId() {
        id = id + 1;
    }
}