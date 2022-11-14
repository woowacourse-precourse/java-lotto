package lotto.model;

import java.util.List;

public class Revenue {
    private static int reward = 0;

    private static long oneRevenue(WinDetail winDetail){
        return winDetail.reward();
    }

    public static long revenue(List<WinDetail> result){
        for(WinDetail win : result) {
            reward += oneRevenue(win);
        }
        return reward;
    }

    public static double rate(String money, long reward){
        double rate = (double)reward / Double.parseDouble(money)* 100;
        rate = Math.round(rate*10.0)/10.0;
        return rate;
    }
}
