package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystem {
    InputView inputView = new InputView();
    UserService userService = new UserService();
    LottoService lottoService = new LottoService();
    OutputView outputView = new OutputView();

    public void start() {
        int quantity = inputMoney();
        printLottoQuantity(quantity);
        lottoService.setLotto(quantity);
        printLottoNumbers();
        inputNumbers();
        inputBonusNumber();
        lottoService.getWinningHistory(userService.getUser().getNumbers(), userService.getUser().getBonusNumber());
        printWinStatistics(quantity);
    }

    private int inputMoney() {
        userService.setMoneyToUser(inputView.inputMoney());
        return userService.getLottoQuantity();
    }

    private void printLottoQuantity(int quantity) {
        outputView.lottoQuantityPrint(quantity);
    }

    private void printLottoNumbers() {
        for (Lotto lottery : lottoService.getLottoNumbers()) {
            System.out.println(lottery.getNumbers());
        }
    }

    private void inputNumbers() {
        userService.setNumbersToUser(inputView.inputNumbers());
    }

    private void inputBonusNumber() {
        userService.setBonusNumber(inputView.inputBonusNumber());
    }

    private void printWinStatistics(int quantity) {
        System.out.println("당첨 통계\n" +
                "---");
        outputView.lottoQuantityPrint(quantity);
        outputView.winningHistoryPrint();
        outputView.returnPrint(quantity);
    }
}
