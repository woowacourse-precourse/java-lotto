package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.Constant;
import lotto.util.WinnerInfo;

public class Service {

    public static int countLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }

    public static long getProfitRates(int purchaseAmount, int winningAmount) {
        return winningAmount / purchaseAmount;
    }

    // TODO: 리팩토링 필요
    public static int getLottoResult(
            List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {

        int count = 0;
        List<Integer> intersection = new ArrayList<>(playerLottoNumbers);
        intersection.retainAll(lottoNumbers);

        if (intersection.size() == Constant.CHECK_BONUS_COUNT) {
            playerLottoNumbers.removeAll(lottoNumbers);

            if (playerLottoNumbers.get(0) == playerBonusNumber) {
                return WinnerInfo.RANK2.getRank();
            }
            return WinnerInfo.RANK3.getRank();
        }

        if (intersection.size() == WinnerInfo.RANK1.getWinningCondition()) {
            return WinnerInfo.RANK1.getRank();
        }

        if (intersection.size() == WinnerInfo.RANK4.getWinningCondition()) {
            return WinnerInfo.RANK4.getRank();
        }
        return WinnerInfo.RANK5.getRank();
    }

}
