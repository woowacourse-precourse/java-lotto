package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int userMoney = Util.inputUserMoney();

        int userLottoCnt = LottoUtil.numberOfLottoAvailableCount(userMoney);

        List<Lotto> userLottos = LottoUtil.getLottos(userLottoCnt);

        List<Integer> winNumber = Util.inputWinNumber();

        int bonusNumber = Util.inputBonusNumber();

        List<Integer> winStatistics = LottoUtil.checkWin(userLottos, winNumber);
        List<Boolean> bonusStatistics = LottoUtil.checkBonus(userLottos, bonusNumber);

        for(int i = 0 ; i < winStatistics.size() ; i++){
            System.out.print(winStatistics.get(i) + " ");
        }

        System.out.println();

        for(int i = 0 ; i < bonusStatistics.size() ; i++){
            System.out.print(bonusStatistics.get(i) + " ");
        }

    }
}
