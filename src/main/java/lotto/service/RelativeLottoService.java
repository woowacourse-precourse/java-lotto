package lotto.service;

import lotto.view.InputOutputView;

import java.util.List;

public class RelativeLottoService {
    private BuyLotto buyLotto = new BuyLotto();
    private InputOutputView inputOutputView = new InputOutputView();
    private ProduceWinningNumbers produceWinningNumbers = new ProduceWinningNumbers();

    private int money;
    private int bonusNumber;
    private int quantity;
    private List<List<Integer>> myLottoNumbers;
    private List<Integer> winningNumbers;

    public int getMoney() {
        return money;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<List<Integer>> getMyLottoNumbers() {
        return myLottoNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void relativeLottoNumber() {
        money = inputOutputView.buyMoney();
        quantity = buyLotto.buyLotto(money);
        myLottoNumbers = buyLotto.getMyLottoNumbers(quantity);
        winningNumbers = produceWinningNumbers.getWinningNumbers();
        bonusNumber = produceWinningNumbers.getBonusNumber(winningNumbers);
    }
}
