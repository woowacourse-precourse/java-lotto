package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Revenue {
    private static final int ZERO_COUNT=0;
    private static final int ZERO_REVENUE=0;

    private final HashMap<String, Integer> revenueStatics=new HashMap<>();
    private int revenue;

    public Revenue(){
        revenue=ZERO_REVENUE;
    }

    public int getRevenue(){
        return revenue;
    }
    public HashMap<String, Integer> getRevenueStatics(){
        return revenueStatics;
    }

    public void initializeRevenueStatics(){
        List<String> rankNames=Rank.getRankNames();
        for(String rankName: rankNames){
            revenueStatics.put(rankName, ZERO_COUNT);
        }
    }

    public void updateRevenueStatics(String rankName){
        int count = revenueStatics.get(rankName);
        revenueStatics.put(rankName, ++count);
    }
    public void settleRevenue(int winnings){
        revenue+=winnings;
    }
    public void makeStatics(List<List<Integer>> matches){
        String rankName;
        int winnings;
        initializeRevenueStatics();
        for(List<Integer> match:matches){
            rankName = Rank.getRankNameByMatchState(match);
            winnings = Rank.getWinningsByMatchState(match);
            updateRevenueStatics(rankName);
            settleRevenue(winnings);
        }
    }
}
