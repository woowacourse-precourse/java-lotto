package vo;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(1, 6, 2_000_000_000, "6개 일치 (2,000,000,000원)", false),
    SECOND(2, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", true),
    THIRD(3, 5, 1_500_000, "5개 일치 (1,500,000원)", false),
    FOURTH(4, 4, 50_000, "4개 일치 (50,000원)", false),
    FIFTH(5, 3, 5_000, "3개 일치 (5,000원)", false),
    OUT(6, 0, 0, "", false);

    private final int ranking;
    private final int correct;
    private final int reward;
    private final String message;
    private final boolean bonusScore;

    LottoRanking(int ranking, int correct, int reward, String message, boolean bonusScore) {
        this.ranking = ranking;
        this.correct = correct;
        this.reward = reward;
        this.message = message;
        this.bonusScore = bonusScore;
    }

    public String getMessage() {
        return message;
    }

    public int getRanking() {
        return ranking;
    }

    public int getCorrect() {
        return correct;
    }

    public boolean isBonusScore() {
        return bonusScore;
    }

    public int getReward() {
        return reward;
    }

    public static LottoRanking getRanking(int correct, boolean bonusScore) {
        return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.correct == correct && lottoRanking.bonusScore == bonusScore)
                .findFirst()
                .orElse(OUT);
    }

    public static LottoRanking findByRanking(int ranking) {
        return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.ranking == ranking)
                .findFirst()
                .orElse(OUT);
    }
}

