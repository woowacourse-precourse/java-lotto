package lotto;

import java.util.List;

public class PriceChecker {
    public static PrizeDetails getPrizeCount(List<Integer> purchasedLottoNumbers, List<Integer> prizeNumbers) {
        PrizeDetails prizeDetail = PrizeDetails.NOT_THING;
        for (Integer prizeNumber : prizeNumbers) {
            if (hasLottoNumber(purchasedLottoNumbers, prizeNumber)) {
                prizeDetail = prizeDetail.next();
            }
        }

        return prizeDetail;
    }

    public static PrizeDetails updateLottoPrizeDetailsWhenHasBonusNumber(Lotto lotto, Integer bonusNumber) {
        PrizeDetails prizeDetails = lotto.getPriceDetails();
        if (hasBonusNumber(lotto.getNumbers(), bonusNumber)) {
            prizeDetails = prizeDetails.next();
            if (prizeDetails == PrizeDetails.SIX_PRIZE) {
                prizeDetails = PrizeDetails.FIVE_PRIZE_AND_BONUS;
            }
        }
        return prizeDetails;
    }

    public static boolean hasBonusNumber(List<Integer> purchasedLottoNumbers, int bonusNumber) {
        return hasLottoNumber(purchasedLottoNumbers, bonusNumber);
    }

    private static boolean hasLottoNumber(List<Integer> purchasedLottoNumbers, Integer number) {
        for (Integer prizeNumber : purchasedLottoNumbers) {
            if (prizeNumber == number) return true;
        }
        return false;
    }
}
