package lotto;

import constant.LottoRule;
import constant.Prize;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistics {
    private static final int DEFAULT_VALUE = 0;

    public Map<Prize, Integer> produce(WinLotto winLotto, List<Lotto> lottos) {
        Map<Prize, Integer> output = new EnumMap<>(Prize.class);
        Set<Integer> winNumbers = new HashSet<>(winLotto.getNumbers());
        int bonusNumber = winLotto.getBonusNumber(); 
        
        for (Lotto lotto : lottos) {
            pileUpOutput(output, winNumbers, bonusNumber, lotto);
        }

        return output;
    }

    private void pileUpOutput(Map<Prize, Integer> result, Set<Integer> winNumbers, int bonusNumber, Lotto lotto) {
        Set<Integer> numbers = new HashSet<>(lotto.getNumbers());
        int match = getMatch(winNumbers, numbers);
        boolean bonus = isNecessaryBonus(bonusNumber, numbers, match);
        Prize prize = Prize.search(match, bonus);

        if (prize == Prize.NONE) {
            return;
        }

        Integer count = result.getOrDefault(prize, DEFAULT_VALUE);
        result.put(prize, count + 1);
    }

    private int getMatch(Set<Integer> winNumbers, Set<Integer> numbers) {
        numbers.removeAll(winNumbers);
        return LottoRule.SIZE.getValue() - numbers.size();
    }
}
