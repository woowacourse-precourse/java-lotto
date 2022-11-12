package lotto;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Map<Integer, Integer> result;
        List<Lotto> lottos;
        List<Integer> winningNumber;

        try {
            LottoManager lottoManager = new LottoManager();

            int userMoney = lottoManager.getMoney();

            lottos = lottoManager.publishLottoForPrice(userMoney);

            winningNumber = lottoManager.GenerateLottoNumbers();

            int bonusNumber = lottoManager.GenerateBonusNumber();

            result = Referee.compare(bonusNumber, winningNumber, lottos);

            lottoManager.printWinningMessage(result);

            lottoManager.printProfit(userMoney, result);

        } catch (IllegalArgumentException e) {
            return;
        }



    }
}
