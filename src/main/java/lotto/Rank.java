package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 순를 나타내는 enum
 * 점수는 당첨번호 하나당 2점 보너스 점수는 1점으로 계산
 */
public enum Rank {
    FIRST_CLASS("6개 일치 (2,000,000,000원)", 2000000000, 12),
    SECOND_CLASS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000,11),
    THIRD_CLASS("5개 일치 (1,500,000원)", 1500000, 10),
    FIRTH_CLASS("4개 일치 (50,000원)", 50000, 8),
    FIFTH_CLASS("3개 일치 (5,0000원)", 5000, 6),
    LOSE_LOTTO("낙첨",0, 0);

    private final static Map<Integer, Rank> BY_SCORE = Stream.of(values())
            .collect(Collectors.toMap(Rank::getScore, Function.identity()));

    private final String winningContent;
    private final long prizeMoney;
    private final int score;

    Rank(String winningContent, long prizeMoney, int score) {
        this.winningContent = winningContent;
        this.prizeMoney = prizeMoney;
        this.score = score;
    }

    public String getWinningContent() {
        return this.winningContent;
    }

    public int getScore() {
        return this.score;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }

    public static Rank findByScore(int score) {
        if (score < 6) {
            return BY_SCORE.get(0);
        }
        return BY_SCORE.get(score);
    }

    public static List<Rank> getSortRanks() {
        return Stream.of(Rank.values())
                .sorted((rank1, rank2) -> rank1.getScore() - rank2.getScore())
                .collect(Collectors.toList());
    }
}
