package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.constant.WinningResult;
import lotto.ui.UserInterface;

public class Cashier {
    private List<Lotto> lottos;
    private final Account account;
    private final WinningCalculator winningCalculator;

    public Cashier() {
        this.winningCalculator = new WinningCalculator();
        this.account = new Account(winningCalculator);
    }

    public void sellLottos() {
        publishLottos();
        setWinningRule();
        saveResultInAccount();
        getResultInAccount();
        getYieldInAccount();
    }

    public void publishLottos() {
        String inputMoneyRaw = UserInterface.getInputMoney();
        this.lottos = LottoMachine.publish(inputMoneyRaw);
    }

    public void saveResultInAccount() {
        this.account.saveResult(lottos);
    }

    public void setWinningRule() {
        setWinningNumbers();
        setBonusNumber();
    }

    public void getResultInAccount() {
        Map<WinningResult, Integer> results = this.account.getWinningResultTable();
        UserInterface.printResult(results);
    }

    public void getYieldInAccount() {
        String yield = this.account.getYield();
        UserInterface.printYield(yield);
    }

    private void setWinningNumbers() {
        String numbersRaw = UserInterface.getWinningNumbers();
        this.winningCalculator.setWinningNumbers(numbersRaw);
    }

    private void setBonusNumber() {
        String bonusNumberRaw = UserInterface.getBonusNumber();
        this.winningCalculator.setBonusNumber(bonusNumberRaw);
    }

}
