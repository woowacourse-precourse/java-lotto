package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
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


    public static LottoResult of(Lotto lotto,
                                 List<Integer> winningNumbers,
                                 int bonusNumber) {
        long matchingNumberCount = lotto.compareWinningNumbers(winningNumbers);

        if (matchingNumberCount == 3) {
            return THREE;
        }

        if (matchingNumberCount == 4) {
            return FOUR;
        }

        if (matchingNumberCount == 5) {
            if (lotto.isContainBonusNumber(bonusNumber)) {
                return FIVE_WITH_BONUS;
            }
            return FIVE;
        }
        if (matchingNumberCount == 6) {
            return SIX;
        }
        return ELSE;
    }
}
