package lotto.domain;

import java.text.DecimalFormat;
import java.util.Map;

public enum LottoResult {

    ELSE(0, "3개 미만"),
    THREE( 5_000, "3개 일치"),
    FOUR(50_000, "4개 일치"),
    FIVE(1_500_000, "5개 일치"),
    FIVE_WITH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치"),
    SIX(2_000_000_000, "6개 일치");

    private int payout;
    private String status;

    LottoResult(int payout, String status) {
        this.payout = payout;
        this.status = status;
    }

    public void printMessage(Map<LottoResult, Long> lottoResultToCount) {
        DecimalFormat df = new DecimalFormat("###,###");
        String message = status + " " +
                "(" + df.format(payout) + "원)" +
                " - " + lottoResultToCount.getOrDefault(this, 0L) + "개";
        System.out.println(message);
    }

    public int getPayout() {
        return payout;
    }
}
