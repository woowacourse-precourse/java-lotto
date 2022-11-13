package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Integer, Integer> result;
        List<Lotto> lotto;
        List<Integer> winningNumber;

        try {
            LottoManager lottoManager = new LottoManager();

            int userMoney = lottoManager.getMoney();

            lotto = lottoManager.publishLottoForPrice(userMoney);

            winningNumber = lottoManager.GenerateLottoNumbers();

            int bonusNumber = lottoManager.GenerateBonusNumber();

            result = Referee.compare(bonusNumber, winningNumber, lotto);

            lottoManager.printWinningMessage(result);

            lottoManager.printProfit(userMoney, result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
