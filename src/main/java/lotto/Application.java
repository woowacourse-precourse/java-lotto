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

        LottoUtil.checkWin(userLottos, winNumber);
    }
}
