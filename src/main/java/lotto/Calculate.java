package lotto;

import constant.Prize;

import java.util.Map;

public class Calculate {

    public double yield(int purchasePrice, Map<Prize, Integer> lottoStatics) {
        Long profits = 0L;

        for (Map.Entry<Prize, Integer> prizeCountEntry : lottoStatics.entrySet()) {
            profits += (long)prizeCountEntry.getKey().getMoney() * prizeCountEntry.getValue();
        }
        return profits / (double)purchasePrice * 100;
    }
}
