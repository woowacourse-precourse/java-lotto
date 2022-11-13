package lotto.repository;

import lotto.domain.Purchaser;

import java.util.HashMap;
import java.util.Map;

public class PurchaserRepository {
    private Long id = 1L;
    private final Map<Long, Purchaser> repository = new HashMap<>();

    public Long insert(Purchaser purchaser) {
        Long purchaserId = id;
        repository.put(purchaserId, purchaser);
        incrementId();
        return purchaserId;
    }

    public Purchaser findById(Long id) {
        return repository.get(id);
    }

    public void save(Long purchaserId, Purchaser purchaser) {
        repository.put(purchaserId, purchaser);
    }

    private void incrementId() {
        id = id + 1;
    }

}