package lotto.domain.winning;

import java.util.List;
import lotto.domain.winning.ball.Ball;

public class WinningDetail {
    private final WinningRank rank;
    private final List<Ball> balls;
    
    public WinningDetail(WinningRank rank, List<Ball> balls) {
        this.rank = rank;
        this.balls = balls;
    }
    
    public WinningRank getRank() {
        return rank;
    }
    
    public List<Ball> getBalls() {
        return balls;
    }
}
