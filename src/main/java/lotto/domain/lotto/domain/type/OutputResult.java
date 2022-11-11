package lotto.domain.lotto.domain.type;

public enum OutputResult {

    MATCH_NUMBER_THREE(3, 0, "3개 일치 (5,000) - %d개"),
    MATCH_NUMBER_FOUR(4, 0, "4개 일치 (50,000원) - %d개"),
    MATCH_NUMBER_FIVE(5, 0, "5개 일치 (1,500,000원) - %d개"),
    MATCH_NUMBER_FIVE_BONUS(6, 1, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    MATCH_NUMBER_SIX(7, 0, "6개 일치 (2,000,000,000원) - %d개");

    private final int prize;
    private final int bonus;
    private final String message;

    OutputResult(int prize, int bonus, String message) {
        this.prize = prize;
        this.bonus = bonus;
        this.message = message;
    }

    public static String getMessage(int prize, int bonus) {
        OutputResult[] values = OutputResult.values();
        for (OutputResult outputResult : values) {
            if (outputResult.prize == prize && outputResult.bonus == bonus) {
                return outputResult.message;
            }
        }
        return "%d";
    }

}
