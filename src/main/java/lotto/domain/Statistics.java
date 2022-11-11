package lotto.domain;


import lotto.config.InputConfig;

import java.util.*;

public class Statistics {
    private final Lotto prizeLotto;
    private final int bonusNumber;
    private Map<Winner, Integer> result;

    public Statistics(Lotto prizeLotto, int bonusNumber) {
        this.prizeLotto = prizeLotto;
        this.bonusNumber = bonusNumber;
        InputConfig.checkPrizeLottoWithBonus(prizeLotto, bonusNumber);
    }

    private void initResult() {
        Map<Winner, Integer> tmp = new EnumMap<>(Winner.class);
        for (Winner winner : Winner.values()) {
            tmp.put(winner, 0);
        }
        this.result = tmp;
    }

}
