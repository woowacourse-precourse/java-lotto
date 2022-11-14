package lotto.repository;

import lotto.domain.Statistics;

import java.util.HashMap;
import java.util.Map;

public class StatisticsRepository {
    private Long id;
    private final Map<Long, Statistics> repository = new HashMap<>();

    public void insert(Long purchaserId, Statistics statistics){
        repository.put(purchaserId, statistics);
    }

    public Statistics findByPurchaserId(Long purchaserId){
        return repository.get(purchaserId);
    }
}
