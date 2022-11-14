package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private List<Lotto> lottos;
    private Map<WinningResult, Integer> statistics;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
        this.statistics = new EnumMap<WinningResult, Integer>(WinningResult.class);
    }

    public void buyLottos(int count) {
        for (int idx = 0; idx < count; idx++) {
            lottos.add(new Lotto(Utils.pickUnique6Numbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoBuyCount(int paidMoney) {
        return paidMoney / LottoInfo.PRICE.getValue();
    }

    public List<Integer> getWinningNumbers(List<Integer> numbers) {
        Utils.validateLottoNumbers(numbers);
        return numbers;
    }

    public int getBonusNumber(int number, List<Integer> winning) {
        if (winning.contains(number)) {
            throw new IllegalArgumentException();
        }
        if (number < LottoInfo.START_NUMBER.getValue() || number > LottoInfo.END_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public Map<WinningResult, Integer> getStatistics() {
        return statistics;
    }

    public void calculateResult(List<Integer> winning, int bonus) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchNumberCount(winning);
            boolean haveBonus = lotto.haveBonusNumber(bonus);
            WinningResult key = WinningResult.findByMatchCountAndBonus(matchCount, haveBonus);
            statistics.put(key, statistics.getOrDefault(key, 0) + 1);
        }
    }
}
