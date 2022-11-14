package lotto.domain.winning;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.winning.ball.Ball;
import lotto.domain.lotto.Lotto;

public class WinningNumberComparator {
    
    private final WinningNumber winningNumber;
    
    public WinningNumberComparator(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }
    
    public Optional<WinningDetail> compare(Lotto lotto) {
        List<Ball> matchBalls = getMatchBalls(lotto);
        Optional<WinningRank> winningRank = WinningRank.getRank(matchBalls);
        
        return winningRank.map(rank -> new WinningDetail(rank, matchBalls));
    }
    
    private List<Ball> getMatchBalls(Lotto lotto) {
        List<Ball> result = new ArrayList<>();
        
        for (Integer userNumber : lotto.getNumbers()) {
            Optional<Ball> matchNormalBall = findMatchNormalBall(userNumber);
            matchNormalBall.ifPresent(result::add);
        }
        
        for (Integer userNumber : lotto.getNumbers()) {
            Optional<Ball> matchBonusBall = findMatchBonusBall(userNumber);
            matchBonusBall.ifPresent(result::add);
        }
        
        return result;
    }
    
    private Optional<Ball> findMatchNormalBall(Integer userNumber) {
        return winningNumber.getNormalNumbers().stream().filter((ball) -> ball.getNumber().equals(userNumber))
                .findFirst();
    }
    
    private Optional<Ball> findMatchBonusBall(Integer userNumber) {
        return winningNumber.getBonusNumbers().stream().filter((ball) -> ball.getNumber().equals(userNumber))
                .findFirst();
    }
}
