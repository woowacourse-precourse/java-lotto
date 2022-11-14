package lotto.domain.winning.statistic;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.winning.WinningDetail;
import lotto.domain.winning.WinningRank;

public class WinningStatistic {
    
    private final List<WinningDetail> winningDetails;
    
    public WinningStatistic(List<WinningDetail> winningDetails) {
        this.winningDetails = winningDetails;
    }
    
    public Long getTotalReward() {
        Long totalReward = 0L;
        
        for (WinningDetail winningDetail : winningDetails) {
            totalReward += winningDetail.getRank().getReward();
        }
        
        return totalReward;
    }
    
    public Map<Integer, Integer> getWinningCountByRank() {
        Map<Integer, Integer> result = new HashMap<>();
        
        for (WinningDetail winningDetail : winningDetails) {
            WinningRank winningRank = winningDetail.getRank();
            Integer rank = winningRank.getRank();
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        
        return result;
    }
}
