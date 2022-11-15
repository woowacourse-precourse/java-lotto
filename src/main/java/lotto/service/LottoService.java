package lotto.service;

import lotto.domain.*;
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

    public Long generatePurchaser(String money) {
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

    public double computeRateReturn(Long purchaserId) {
        Purchaser purchaser = purchaserRepository.findById(purchaserId);
        Statistics statistics = statisticsRepository.findByPurchaserId(purchaserId);

        return statistics.computeRateReturn(purchaser.getMoney());
    }

    public List<Integer> generateWinningLottoNumbers(String numbers) {
        Lotto winningLotto = new Lotto(numbers);

        return winningLotto.getNumbers();
    }

    public int generateBonusNumber(String number) {
        Bonus bonus = new Bonus(number);
        return bonus.getNumber();
    }

}