package lotto;

import java.util.Arrays;
public enum Collect {
    FIFTH("3개 일치 (5,000원)", 3.0f, 5000),
    FOURTH("4개 일치 (50,000원)", 4.0f, 50000),
    THIRD("5개 일치 (1,500,000원)", 5.0f, 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5.5f, 30000000),
    FIRST("6개 일치 (2,000,000,000원)", 6.0f, 2000000000);
    private final String description;
    private final Float score;

    private final Integer prize;

    private Collect(String description, Float score, Integer prize) {
        this.description = description;
        this.score = score;
        this.prize = prize;
    }

    public String getDescription() {
        return this.description;
    }
    public Float getScore() {
        return this.score;
    }

    public Integer getPrize() {
        return this.prize;
    }
    public static Collect find(Float score) {
        return Arrays.stream(values())
                .filter(collect -> collect.score.equals(score))
                .findAny()
                .orElse(null);
    }
}