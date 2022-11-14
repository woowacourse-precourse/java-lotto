package lotto.domain.winning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lotto.domain.winning.ball.Ball;
import lotto.domain.winning.ball.BallEnum;

public class WinningRank {
    
    public static final List<WinningRank> ranks = new ArrayList<>();
    
    private final Integer rank;
    private final Integer reward;
    private final Integer countNormalMatch;
    private final Integer countBonusMatch;
    
    public WinningRank(Integer rank, Integer reward, Integer countNormalMatch, Integer countBonusMatch) {
        this.rank = rank;
        this.reward = reward;
        this.countNormalMatch = countNormalMatch;
        this.countBonusMatch = countBonusMatch;
    }
    
    static {
        ranks.addAll(List.of(
                new WinningRank(1, 2000000000, 6, 0),
                new WinningRank(2, 30000000, 5, 1),
                new WinningRank(3, 1500000, 5, 0),
                new WinningRank(4, 50000, 4, 0),
                new WinningRank(5, 5000, 3, 0)
        ));
    }
    
    public Integer getRank() {
        return rank;
    }
    
    public Integer getReward() {
        return reward;
    }
    
    public Integer getCountNormalMatch() {
        return countNormalMatch;
    }
    
    public Integer getCountBonusMatch() {
        return countBonusMatch;
    }
    
    public static Optional<WinningRank> getRank(List<Ball> matchBalls) {
        int normalMatchCount = (int) matchBalls.stream().filter(ball -> ball.getType().equals(BallEnum.NORMAL)).count();
        int bonusMatchCount = (int) matchBalls.stream().filter(ball -> ball.getType().equals(BallEnum.BONUS)).count();
        
        return findByMatchCounts(normalMatchCount, bonusMatchCount);
    }
    
    private static Optional<WinningRank> findByMatchCounts(int normalMatchCount, int bonusMatchCount) {
        return WinningRank.ranks.stream()
                .filter((rank) -> rank.countNormalMatch.equals(normalMatchCount) && rank.countBonusMatch.equals(
                        bonusMatchCount)).findFirst();
    }
    
    public static List<WinningRank> getSortedListByRankASC() {
        List<WinningRank> result = WinningRank.ranks;
        result.sort(Comparator.comparingInt((WinningRank r) -> -r.getRank()));
        return result;
    }
}
