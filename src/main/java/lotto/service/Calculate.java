package lotto.service;

import java.util.Map;
import lotto.model.Prize;

public class Calculate {

    public double yield(int purchasePrice, Map<Prize, Integer> lottoStatics) {
        long profits = 0L;

        for (Map.Entry<Prize, Integer> prizeCountEntry : lottoStatics.entrySet()) {
            profits += (long) prizeCountEntry.getKey().getMoney() * prizeCountEntry.getValue();
        }
        return profits / (double) purchasePrice * 100;
    }
}
