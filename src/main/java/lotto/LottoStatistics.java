package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {



    public String checkBonusNumber(Lotto lotto, int bonus, String key) {
        String newKey = key;
        if (lotto.existsNumber(bonus)) {
            newKey = "bonus";
        }
        return newKey;
    }
}
