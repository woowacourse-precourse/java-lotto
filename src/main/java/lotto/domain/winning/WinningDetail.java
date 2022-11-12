package lotto.domain.winning;

import java.util.List;
import java.util.Optional;
import lotto.domain.ball.Ball;

public class WinningDetail {
    private WinningRank rank;
    private final List<Ball> balls;
    
    public WinningDetail(WinningRank rank, List<Ball> balls) {
        this.rank = rank;
        this.balls = balls;
    }
    
    public WinningDetail(List<Ball> balls) {
        this.balls = balls;
    }
    
    public Optional<WinningRank> getRank() {
        return Optional.ofNullable(rank);
    }
    
    public List<Ball> getBalls() {
        return balls;
    }
}
