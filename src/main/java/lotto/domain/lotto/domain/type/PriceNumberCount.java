package lotto.domain.lotto.domain.type;

public enum PriceNumberCount {

    MATCH_THREE(3, 0, "일치하는 볼 개수 3개, 보너스 볼 개수 0개"),
    MATCH_FOUR(4, 0, "일치하는 볼 개수 4개, 보너스 볼 개수 0개"),
    MATCH_FIVE(5, 0, "일치하는 볼 개수 5개, 보너스 볼 개수 0개"),
    MATCH_FIVE_BONUS(5, 1, "일치하는 볼 개수 5개, 보너스 볼 개수 1개"),
    MATCH_SIX(6, 0, "일치하는 볼 개수 6개, 보너스 볼 개수 0개");

    private final int prize;
    private final int bonus;
    private final String message;

    PriceNumberCount(int prize, int bonus, String message) {
        this.prize = prize;
        this.bonus = bonus;
        this.message = message;
    }

}
