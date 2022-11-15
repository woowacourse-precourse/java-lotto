package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Money;
import lotto.model.Service;
import lotto.util.LottoGenerator;
import lotto.util.PlayerInput;
import lotto.util.WinnerInfo;
import lotto.view.View;

/*
 * 로또 게임의 전체 로직을 담당하는 객체
 */

public class Controller {

    public void run() {
        try {
            setGame();
        } catch (IllegalArgumentException ie) {
            return;
        }
    }

    public void setGame() {
        Service service;

        int money = getMoney();
        int lottoAmount = getLottoAmount(money);
        List<List<Integer>> lottoNumbers = getLottoNumbers(lottoAmount);
        View.printPurchaseInformation(lottoAmount, lottoNumbers);

        List<Integer> winningLottoNumber = getWinningLottoNumber();
        int winningBonusNumber = getWinningBonusNumber();

        service = new Service(lottoAmount, lottoNumbers, winningLottoNumber, winningBonusNumber);
        int[] lottoResult = service.getLottoResult();
        double profitRates = getProfitRates(money, lottoResult);
        View.printResult(lottoResult);
        View.printProfitRates(profitRates);
    }

    private int getMoney() {
        View.printInputMoney();
        Money money = new Money(PlayerInput.getInteger());
        return money.getMoney();
    }

    private int getLottoAmount(int money) {
        return money / Money.getLottoPrice();
    }

    private List<List<Integer>> getLottoNumbers(int lottoAmount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateLottoNumbers());
            lottoNumbers.add(lotto.getNumbers());
        }
        return lottoNumbers;
    }

    private List<Integer> getWinningLottoNumber() {
        View.printInputLottoNumbers();
        Lotto lotto = new Lotto(PlayerInput.getLottoNumbers());
        return lotto.getNumbers();
    }

    private int getWinningBonusNumber() {
        View.printInputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(PlayerInput.getInteger());
        return bonusNumber.getNumber();
    }

    private double getProfitRates(int money, int[] lottoResult) {
        double winningAmount = 0;

        for (int i = 0; i < lottoResult.length; i++) {
            winningAmount += lottoResult[i] * WinnerInfo.values()[i].getPrizeInformation();
        }
        return (winningAmount / money) * 100;
    }

}
