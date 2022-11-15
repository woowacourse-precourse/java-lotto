package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int userMoney = Util.inputUserMoney();

        int userLottoCnt = LottoUtil.numberOfLottoAvailableCount(userMoney);

        List<Lotto> userLottos = LottoUtil.getLottos(userLottoCnt);

        List<Integer> winNumber = Util.inputWinNumber();

        int bonusNumber = Util.inputBonusNumber(winNumber);

        List<Integer> winStatistics = LottoUtil.checkWin(userLottos, winNumber);
        List<Boolean> bonusStatistics = LottoUtil.checkBonus(userLottos, bonusNumber);


        List<Integer> ranks = LottoUtil.creatRank(winStatistics, bonusStatistics);
        LottoUtil.calculateRevenue(ranks, userLottoCnt);

    }
}
