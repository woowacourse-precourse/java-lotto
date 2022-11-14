package lotto.service;

import lotto.domain.PrizeMoney;
import lotto.domain.Purchaser;
import lotto.domain.Statistics;
import lotto.repository.PurchaserRepository;
import lotto.repository.StatisticsRepository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoService {
    private final PurchaserRepository purchaserRepository;
    private final StatisticsRepository statisticsRepository;

    public LottoService() {
        purchaserRepository = new PurchaserRepository();
        statisticsRepository = new StatisticsRepository();
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

    public void matchLottos(Long purchaserId, List<Integer> winningLottoNumbers, int bonusNumber) {
        Purchaser purchaser = purchaserRepository.findById(purchaserId);
        Statistics statistics = new Statistics();
        statistics.countWinningLotto(purchaser.getLottos(), winningLottoNumbers, bonusNumber);
        statisticsRepository.insert(purchaserId, statistics);
    }

    public Map<PrizeMoney, Integer> findPurchaserWinningHistory(Long purchaserId) {
        Statistics statistics = statisticsRepository.findByPurchaserId(purchaserId);
        return statistics.getWinningHistory();
    }

    public String computeRateReturn(Long purchaserId) {
        Purchaser purchaser = purchaserRepository.findById(purchaserId);
        Statistics statistics = statisticsRepository.findByPurchaserId(purchaserId);

        Long profit = computeProfit(statistics.getWinningHistory());
        int money = purchaser.getMoney();
        double rateReturn = (double) profit / money * 100;

        return String.valueOf(rateReturn);
    }

    private Long computeProfit(Map<PrizeMoney, Integer> winningHistory) {
        Long profit = 0L;

        for (Entry<PrizeMoney, Integer> entry : winningHistory.entrySet()) {
            PrizeMoney prizeMoney = entry.getKey();
            int countOfWinning = entry.getValue();

            profit = profit + (long) prizeMoney.getIntegerMoney() * countOfWinning;
        }

        return profit;
    }
}