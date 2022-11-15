package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Revenue {
    private static final int ZERO_COUNT = 0;
    private static final int ZERO_REVENUE = 0;
    private static final int ZERO_RATE = 0;
    private static final String BONUS_CONDITION = "SECOND";
    private static final int PERCENTAGE = 100;

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = "";
    private static final HashMap<String, Integer> revenueStatics = new HashMap<>();
    private static final List<String> revenueStaticsReport = new ArrayList<>();
    private int revenue;
    private float rateOfRevenue;

    public Revenue() {
        revenue = ZERO_REVENUE;
        rateOfRevenue = ZERO_RATE;
    }

    public int getRevenue() {
        return revenue;
    }

    public HashMap<String, Integer> getRevenueStatics() {
        return revenueStatics;
    }

    public void initializeRevenueStatics() {
        List<String> rankNames = Rank.getRankNames();
        for (String rankName : rankNames) {
            revenueStatics.put(rankName, ZERO_COUNT);
        }
    }

    public void updateRevenueStatics(String rankName) {
        int count = revenueStatics.get(rankName);
        revenueStatics.put(rankName, ++count);
    }

    public void settleRevenue(int winnings) {
        revenue += winnings;
    }

    public void makeStatics(List<List<Integer>> matches) {
        String rankName;
        int winnings;
        initializeRevenueStatics();
        for (List<Integer> match : matches) {
            rankName = Rank.getRankNameByMatchState(match);
            winnings = Rank.getWinningsByMatchState(match);
            updateRevenueStatics(rankName);
            settleRevenue(winnings);
        }
    }

    public void calculateRateOfRevenue(int purchaseAmount) {
        rateOfRevenue = (float) revenue / (float) purchaseAmount * PERCENTAGE;
    }

    public float getRateOfRevenue() {
        return rateOfRevenue;
    }

    public boolean isSecond(String rankName) {
        return rankName.equals(BONUS_CONDITION);
    }

    public String makeReportFormat(int raffleMatchCount, String rankName) {
        String reportFormat;
        reportFormat = String.format("%d개 일치 (%s원) - %d개", raffleMatchCount, WinningsTable.getWinningsByMatchState(rankName), revenueStatics.get(rankName));
        if (isSecond(rankName)) {
            reportFormat = String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", raffleMatchCount, WinningsTable.getWinningsByMatchState(rankName), revenueStatics.get(rankName));
        }
        return reportFormat;
    }

    public String getRevenueStaticsReport() {
        List<String> rankNames = Rank.getRankNames();
        Collections.reverse(rankNames);
        String winResult;
        int raffleMatchCount;
        for (String rankName : rankNames) {
            raffleMatchCount = WinningsTable.getRaffleMatchesByMatchState(rankName);
            winResult = makeReportFormat(raffleMatchCount, rankName);
            revenueStaticsReport.add(winResult + NEW_LINE);
        }
        return String.join(DELIMITER, revenueStaticsReport);
    }
}
