package lotto;

import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {
    InputView inputView = new InputView();
    UserService userService = new UserService();
    OutputView outputView = new OutputView();

    public void start() {
        inputMoney();
        printLottoNumbers();
        inputNumbers();
        inputBonusNumber();
        winStatisticsPrint();
    }

    private void inputMoney() {
        userService.setMoneyToUser(inputView.inputMoney());
    }

    private void printLottoNumbers() {

    }

    private void inputNumbers() {
        userService.setNumbersToUser(inputView.inputNumbers());
    }

    private void inputBonusNumber() {
        userService.setBonusNumber(inputView.inputBonusNumber());
    }

    private void winStatisticsPrint() {
        System.out.println("당첨 통계\n" +
                "---");
        outputView.lottoQuantityPrint(userService.getUser().getMoney()/1000);
        outputView.winningHistoryPrint();
    }
}
