package util;

import domain.lotto.BonusNumber;
import domain.lotto.Lotto;
import java.util.ArrayList;
import java.util.List;
import view.InputView;

public class InputHandler {

    private static final String DIVIDE = ",";

    InputView inputView = new InputView();

    public int getMoney() {
        String money = inputView.readMoney();
        new MoneyValidator(money);
        return Integer.parseInt(money);
    }

    public List<Integer> getWinningNumbers() {
        String winningNumbers = inputView.readWinningNumbers();
        new WinningNumberValidator(winningNumbers);
        return makeWinningNumbersList(winningNumbers);
    }

    public int getBonusNumber(Lotto winningLotto) {
        String bonusNumber = inputView.readBonusNumber();
        new BonusNumberValidator(bonusNumber, winningLotto);
        return Integer.parseInt(bonusNumber);
    }

    private List<Integer> makeWinningNumbersList(String winningNumbers) {
        List<Integer>winningNumber = new ArrayList<>();
        String [] tmpArray = winningNumbers.split(DIVIDE);
        for(String number : tmpArray){
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }
}
