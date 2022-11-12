package lotto;

import java.util.List;
import lotto.model.Service;
import lotto.view.View;

public class Controller {

    public void run() {
        try {
            setGame();
        } catch (IllegalArgumentException ie) {
            return;
        }
    }

    public void setGame() {
        View.printInputMoney();
        int money = Service.getMoney();
        int lottoAmount = Service.getLottoAmount(money);

        List<List<Integer>> lottoNumbers = Service.getLottoNumbers(lottoAmount);
        List<Integer> bonusNumbers = Service.getBonusNumber(lottoAmount);
        View.printPurchaseInformation(lottoAmount, lottoNumbers);

        View.printInputLottoNumbers();
        List<Integer> winningLottoNumber = Service.getWinningLottoNumber();

        View.printInputBonusNumber();
        int winningBonusNumber = Service.getWinningBonusNumber();

        int[] lottoResult = Service.getLottoResult(lottoAmount, lottoNumbers, winningLottoNumber, winningBonusNumber);
        View.printResult(lottoResult);

        double profitRates = Service.getProfitRates(money, lottoResult);
        View.printProfitRates(profitRates);
    }

}
