package lotto.management;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private NumberMatchSystem numberMatchSystem;
    private String purchaseMoney;

    public Controller() {
    }

    public void run() {
        try {
            set();
            result();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void set() {
        purchaseMoney = InputView.enterPurchaseMoney();
        Purchase purchase = new Purchase(purchaseMoney);
        int lottoTickets = purchase.getNumberOfLottoTickets();
        OutputView.printLottoTickets(lottoTickets);

        RandomNumber randomNumber = new RandomNumber(lottoTickets);
        randomNumber.generateRandomNumbers();
        OutputView.printLottoNumbers(randomNumber.getRandomNumbers());

        WinningNumber winningNumber = new WinningNumber(InputView.enterWinningNumbers(),
                InputView.enterBonusNumber());

        numberMatchSystem = new NumberMatchSystem(randomNumber.getRandomNumbers(),
                winningNumber.getWinningNumbers(), winningNumber.getBonusNumber());
    }

    public void result() {
        numberMatchSystem.checkTicket();
        OutputView.printWinningTickets(numberMatchSystem.getTicketsResult());
        WinningAmount winningAmount = new WinningAmount(numberMatchSystem.getTicketsResult(), Integer.parseInt(purchaseMoney));
        OutputView.printLottoYield(winningAmount.getLottoYield());
    }
}
