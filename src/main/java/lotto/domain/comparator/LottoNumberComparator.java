package lotto.domain.comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.ball.Ball;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningRank;

public class LottoNumberComparator {
    
    private final WinningNumber winningNumber;
    
    public LottoNumberComparator(WinningNumber winningNumber) {
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
        return winningNumber.getNormalNumbers().stream().filter((ball) -> ball.getNumber().equals(userNumber))
                .findFirst();
    }
}
