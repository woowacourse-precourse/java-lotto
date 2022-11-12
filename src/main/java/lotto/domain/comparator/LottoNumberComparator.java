package lotto.domain.comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.ball.Ball;
import lotto.domain.winning.WinningNumber;

public class LottoNumberComparator {
    
    private final WinningNumber winningNumber;
    
    public LottoNumberComparator(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }
    
    public void compare(Lotto lotto) {
        List<Ball> matchBalls = getMatchBalls(lotto);
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
