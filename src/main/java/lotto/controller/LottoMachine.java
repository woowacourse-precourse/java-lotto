package lotto.controller;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Utils;
import lotto.domain.Lotto;
import lotto.enums.Error;
import lotto.enums.LottoInfo;
import lotto.enums.WinningResult;

public class LottoMachine {
    private List<Lotto> lottos;
    private Map<WinningResult, Integer> statistics;
    private long reward;
    private double revenue;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
        this.statistics = new EnumMap<WinningResult, Integer>(WinningResult.class);
        this.reward = 0L;
        this.revenue = 0;
    }

    public void buyLottos(int count) {
        for (int idx = 0; idx < count; idx++) {
            lottos.add(new Lotto(Utils.pickUnique6Numbers()));
        }
    }

    public void calculateResult(List<Integer> winning, int bonus) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchNumberCount(winning);
            boolean haveBonus = lotto.haveBonusNumber(bonus);
            WinningResult key = WinningResult.findByMatchCountAndBonus(matchCount, haveBonus);
            statistics.put(key, statistics.getOrDefault(key, 0) + 1);
            reward += key.getReward();
        }
    }

    public void calculateRevenue(int paidMoney) {
        revenue = reward / (double) paidMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoBuyCount(int paidMoney) {
        if (paidMoney < 1000) {
            throw new IllegalArgumentException(Error.ZERO_MONEY_ERROR.getMessage());
        }
        if (paidMoney % LottoInfo.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Error.PAY_MONEY_ERROR.getMessage());
        }
        return paidMoney / LottoInfo.PRICE.getValue();
    }

    public List<Integer> getWinningNumbers(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        return numbers;
    }

    public int getBonusNumber(int number, List<Integer> winning) {
        if (winning.contains(number)) {
            throw new IllegalArgumentException(Error.DUPLICATE_ERROR.getMessage());
        }
        if (number < LottoInfo.START_NUMBER.getValue() || number > LottoInfo.END_NUMBER.getValue()) {
            throw new IllegalArgumentException(Error.RANGE_ERROR.getMessage());
        }
        return number;
    }

    public Map<WinningResult, Integer> getStatistics() {
        return statistics;
    }

    public double getRevenue() {
        return revenue;
    }
}
