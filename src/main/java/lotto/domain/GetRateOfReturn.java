package lotto.domain;

import lotto.view.WinningMessage;

public class GetRateOfReturn {
    public String calculateRate(long [] result, long money){
        long value = result[3] * WinningMessage.THIRD_MATCH.getMoney()
                + result[4] * WinningMessage.FORTH_MATCH.getMoney()
                + result[5] * WinningMessage.FIFTH_MATCH.getMoney()
                + result[6] * WinningMessage.SIXTH_MATCH.getMoney()
                + result[7] * WinningMessage.BONUS_MATCH.getMoney();
        double yield = ((double) value / money) * 100;
        return String.format("%.1f", yield);
    }
}
