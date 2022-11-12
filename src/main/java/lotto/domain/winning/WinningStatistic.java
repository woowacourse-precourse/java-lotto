package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.List;
import lotto.util.Calculator;

public class WinningStatistic {
    
    private final List<WinningDetail> winningDetails;
    
    public WinningStatistic(List<WinningDetail> winningDetails) {
        this.winningDetails = winningDetails;
    }
    
    public String getTextByRateOfReturn(Integer purchaseAmount) {
        return new DecimalFormat("###,###.0").format(Calculator.getRateOfReturn(purchaseAmount, getTotalReward())) +
                "%";
    }
    
    private Long getTotalReward() {
        Long totalReward = 0L;
        
        for (WinningDetail winningDetail : winningDetails) {
            totalReward += winningDetail.getRank().getReward();
        }
        
        return totalReward;
    }
}
