package lotto.domain.winning;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.util.Calculator;

public class WinningStatistic {
    
    private final List<WinningDetail> winningDetails;
    
    public WinningStatistic(List<WinningDetail> winningDetails) {
        this.winningDetails = winningDetails;
    }
    
    public String getTextByRateOfReturn(Integer purchaseAmount) {
        return formatRating(Calculator.getRateOfReturn(purchaseAmount, getTotalReward()));
    }
    
    private Long getTotalReward() {
        Long totalReward = 0L;
        
        for (WinningDetail winningDetail : winningDetails) {
            totalReward += winningDetail.getRank().getReward();
        }
        
        return totalReward;
    }
    
    public List<String> getWinningTextList() {
        Map<Integer, Integer> winningCountByRank = getWinningCountByRank();
        return getSortedByRankASC().stream().map((winningRank -> getWinningTextByRank(winningRank,
                winningCountByRank.getOrDefault(winningRank.getRank(), 0)))).collect(Collectors.toList());
    }
    
    private Map<Integer, Integer> getWinningCountByRank() {
        Map<Integer, Integer> result = new HashMap<>();
        
        for (WinningDetail winningDetail : winningDetails) {
            WinningRank winningRank = winningDetail.getRank();
            Integer rank = winningRank.getRank();
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        
        return result;
    }
    
    private List<WinningRank> getSortedByRankASC() {
        List<WinningRank> result = WinningRank.ranks;
        result.sort(Comparator.comparingInt((WinningRank r) -> -r.getRank()));
        return result;
    }
    
    private String getWinningTextByRank(WinningRank winningRank, Integer count) {
        String normalMatchText = winningRank.getCountNormalMatch() + "개 일치";
        String bonusMatchText = "";
        
        if (winningRank.getCountBonusMatch() > 0) {
            bonusMatchText = ", 보너스 볼 일치";
        }
        
        String detailText = " (" + formatPrice(winningRank.getReward()) + ") - " + count + "개";
        
        return normalMatchText + bonusMatchText + detailText;
    }
    
    private String formatRating(Double target) {
        return new DecimalFormat("###,##0.0").format(target) + "%";
    }
    
    private String formatPrice(Integer target) {
        return new DecimalFormat("###,###").format(target) + "원";
    }
}
