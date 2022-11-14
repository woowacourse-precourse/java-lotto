package lotto.domain.lotto.domain.type;

import java.util.HashMap;
import java.util.Map;

public enum OutputResult {

    // TODO: benefit DecimalFormat 사용하기
    MATCH_NUMBER_THREE(3, 0, 5000, "3개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FOUR(4, 0, 50000, "4개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FIVE(5, 0, 1500000, "5개 일치 (%s원) - %d개"),
    MATCH_NUMBER_FIVE_BONUS(6, 1,  30000000, "5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    MATCH_NUMBER_SIX(7, 0, 2000000000, "6개 일치 (%s원) - %d개");

    private final int prize;
    private final int bonus;
    private final int benefit;
    private final String message;

    OutputResult(int prize, int bonus, int benefit, String message) {
        this.prize = prize;
        this.bonus = bonus;
        this.benefit = benefit;
        this.message = message;
    }

    public static Map<String, String> getMessage(int prize, int bonus) {
        Map<String, String> map = new HashMap<>();
        OutputResult[] values = OutputResult.values();
        for (OutputResult outputResult : values) {
            Map<String, String> equalsValuePutMap = isEqualsValuePutMap(outputResult, prize, bonus, map);
            if (!equalsValuePutMap.isEmpty()) {
                return equalsValuePutMap;
            }
        }
        return null;
    }

    private static Map<String, String> isEqualsValuePutMap(OutputResult outputResult, int prize, int bonus, Map<String, String> map) {
        if (outputResult.prize == prize && outputResult.bonus == bonus) {
            map.put("benefit", String.valueOf(outputResult.benefit));
            map.put("message", outputResult.message);
            map.put("bonus", String.valueOf(outputResult.bonus));
            return map;
        }
        return map;
    }
}
