package lotto;

import constant.Prize;

import java.util.HashMap;
import java.util.Map;

public class PrizeSearchTool {
    static Map<Integer, Map<Boolean, Prize>> matchPrize = new HashMap<>();

    public static void updateSearchTool(Prize prize) {
        int match = prize.getMatch();
        Map<Boolean, Prize> booleanPrize = matchPrize.getOrDefault(match, new HashMap<>());
        booleanPrize.put(prize.isBonus(), prize);
        matchPrize.put(match, booleanPrize);
    }

    public static Prize search(int match, boolean bonus) {
        Map<Boolean, Prize> booleanPrize = matchPrize.get(match);

        if (booleanPrize == null || booleanPrize.size() == 0) {
            return Prize.NONE;
        }

        Prize prize = booleanPrize.get(bonus);

        if (prize == null) {
            return Prize.NONE;
        }

        return prize;
    }
}
