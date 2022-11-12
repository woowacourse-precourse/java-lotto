package lotto.reward;

public enum Reward {
    THREE("3개 일치 (5,000원) - %d개%n"),
    FOUR("4개 일치 (50,000원) - %d개%n"),
    FIVE("5개 일치 (1,500,000원) - %d개%n"),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n"),
    SIX("6개 일치 (2,000,000,000원) - %dro%n"),

    YIELD("총 수익률은 %.1f%%입니다.%n");

    private String reward;
    Reward(String reward) {
        this.reward = reward;
    }
}
