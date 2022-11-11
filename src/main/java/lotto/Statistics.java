package lotto;

import constant.LottoRule;
import constant.Prize;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Statistics {

    public Map<Prize, Integer> produce(WinLotto winLotto, List<Lotto> lottos) {
        Map<Prize, Integer> output = new EnumMap<>(Prize.class);
        Set<Integer> winNumbers = new HashSet<>(winLotto.getNumbers());
        int bonusNumber = winLotto.getBonusNumber(); 
        
        for (Lotto lotto : lottos) {
            pileUpOutput(output, winNumbers, bonusNumber, lotto);
        }

        return output;
    }
}
