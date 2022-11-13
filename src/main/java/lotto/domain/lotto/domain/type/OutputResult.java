package lotto.domain.lotto.domain.type;

import java.util.HashMap;
import java.util.Map;

public enum OutputResult {

    MATCH_NUMBER_THREE(3, 0, "5000", "3개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FOUR(4, 0, "50,000", "4개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FIVE(5, 0, "1,500,000", "5개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FIVE_BONUS(6, 1,  "30,000,000", "5개 일치, 보너스 볼 일치 (%s원) - %d개"),

    MATCH_NUMBER_SIX(7, 0, "2,000,000,000", "6개 일치 (%s원) - %d개");

    private final int prize;
    private final int bonus;
    private final String benefit;
    private final String message;

    OutputResult(int prize, int bonus, String benefit, String message) {
        this.prize = prize;
        this.bonus = bonus;
        this.benefit = benefit;
        this.message = message;
    }

    public static Map<String, String> getMessage(int prize, int bonus) {
        Map<String, String> map = new HashMap<>();
        OutputResult[] values = OutputResult.values();
        for (OutputResult outputResult : values) {
            if (outputResult.prize == prize && outputResult.bonus == bonus) {
                map.put("benefit", outputResult.benefit);
                map.put("message", outputResult.message);
                return map;
            }
        }
        return null;
    }

}
