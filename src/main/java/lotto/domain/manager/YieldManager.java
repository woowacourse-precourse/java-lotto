package lotto.domain.manager;

import lotto.domain.Award;
import lotto.system.Constant;
import lotto.util.Util;

import java.util.List;

public class YieldManager {
    public static float makeYield(List<Award> prize) {
        float beforeMoney = prize.size() * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        for (Award award : prize) {
            totalMoney += award.getReward();
        }
        return Util.calculateYield(totalMoney, beforeMoney);
    }
}
