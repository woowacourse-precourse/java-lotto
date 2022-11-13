package lotto.domain;

import java.util.List;
import lotto.ui.UserInterface;

public class Cashier {
    private List<Lotto> lottos;
    private Account account;
    private WinningCalculator winningCalculator;

    public Cashier() {
        this.winningCalculator = new WinningCalculator();
        this.account = new Account(winningCalculator);
    }

    public void buyLottos() {
        String inputMoneyRaw = UserInterface.getInputMoney();
        int inputMoney = convertStringToInt(inputMoneyRaw);
        this.lottos = LottoMachine.publish(inputMoney);
    }

    public void saveResultInAccount() {
        this.account.saveResult(lottos);
    }

    public void getResultInAccount() {
//        this.account.getResult();
    }

    public void setWinningRule() {
        setWinningNumbers();
        setBonusNumber();
    }

    private void setWinningNumbers() {
        String numbersRaw = UserInterface.getWinningNumbers();
        this.winningCalculator.setWinningNumbers(numbersRaw);
    }

    private void setBonusNumber() {
        String bonusNumberRaw = UserInterface.getBonusNumber();
        this.winningCalculator.setBonusNumber(bonusNumberRaw);
    }

    private int convertStringToInt(String numberRaw) {
        return Integer.parseInt(numberRaw);
    }

}
