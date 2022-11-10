package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Constant;
import lotto.util.Convertor;
import lotto.util.WinnerInfo;

public class Service {

    public static int countLottoAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / 1000;
    }

    public static long getProfitRates(int purchaseAmount, int winningAmount) {
        return winningAmount / purchaseAmount;
    }

    // TODO: 리팩토링 필요
    public static int[] getLottoResult(
            int lottoAmount, List<List<Integer>> lottoNumbers, List<String> playerLottoNumbers,
            int playerBonusNumber) {

        List<Integer> playerLotteryNumbers = Convertor.StringToInteger(playerLottoNumbers); // TODO: 변수명 변경 고려

        int[] result = new int[Constant.WINNER_NUMBER];
        Arrays.fill(result, 0);

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lotto = Convertor.ExtractList(lottoNumbers, i);
            int index = getOneLottoResult(lotto, playerLotteryNumbers, playerBonusNumber);

            if (index == 0) {
                continue;
            }
            result[index - 1]++;
        }
        return result;
    }

    // TODO: 리팩토링 필요
    private static int getOneLottoResult(
            List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {

        int 을count = 0;
        List<Integer> intersection = new ArrayList<>(playerLottoNumbers);
        intersection.retainAll(lottoNumbers);

        if (intersection.isEmpty()) {
            return 0;
        }

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
