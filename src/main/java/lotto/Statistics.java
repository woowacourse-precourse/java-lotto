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
        Map<Prize, Integer> output = getDefaultOutput();
        Set<Integer> winNumbers = new HashSet<>(winLotto.getNumbers());
        int bonusNumber = winLotto.getBonusNumber(); 
        
        for (Lotto lotto : lottos) {
            pileUpOutput(output, winNumbers, bonusNumber, lotto);
        }

        return output;
    }

    private EnumMap<Prize, Integer> getDefaultOutput() {
        return new EnumMap<>(Prize.class){{
            for (Prize prize : Prize.values()) {
                put(prize, DEFAULT_VALUE);
            }
            remove(Prize.NONE);
        }};
    }

    private void pileUpOutput(Map<Prize, Integer> output, Set<Integer> winNumbers, int bonusNumber, Lotto lotto) {
        Set<Integer> numbers = new HashSet<>(lotto.getNumbers());
        int match = getMatch(winNumbers, numbers);
        boolean bonus = isBonus(bonusNumber, numbers, match);
        Prize prize = PrizeSearchTool.search(match, bonus);
        pileUp(output, prize);
    }

    private int getMatch(Set<Integer> winNumbers, Set<Integer> numbers) {
        numbers.removeAll(winNumbers);
        return LottoRule.SIZE.getValue() - numbers.size();
    }

    private boolean isBonus(int bonusNumber, Set<Integer> numbers, int match) {
        if (match == Prize.THIRD.getMatch()) {
            return numbers.contains(bonusNumber);
        }
        return false;
    }

    private void pileUp(Map<Prize, Integer> result, Prize prize) {
        if (prize == Prize.NONE) {
            return;
        }

        Integer count = result.getOrDefault(prize, DEFAULT_VALUE);
        result.put(prize, count + 1);
    }
}
