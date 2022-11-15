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
        getResultFromAccount();
        getYieldFromAccount();
    }

    public void publishLottos() {
        String moneyRaw = UserInterface.inputMoney();
        this.lottos = LottoMachine.publish(moneyRaw);
    }

    public void setWinningRule() {
        setWinningNumbers();
        setBonusNumber();
    }

    public void saveResultInAccount() {
        this.account.saveResult(lottos);
    }

    public void getResultFromAccount() {
        Map<WinningResult, Integer> winningResultTable = this.account.getWinningResultTable();
        UserInterface.printResult(winningResultTable);
    }

    public void getYieldFromAccount() {
        String yield = this.account.getYield();
        UserInterface.printYield(yield);
    }

    private void setWinningNumbers() {
        String numbersRaw = UserInterface.inputWinningNumbers();
        this.winningCalculator.setWinningNumbers(numbersRaw);
    }

    private void setBonusNumber() {
        String bonusNumberRaw = UserInterface.inputBonusNumber();
        this.winningCalculator.setBonusNumber(bonusNumberRaw);
    }
}
