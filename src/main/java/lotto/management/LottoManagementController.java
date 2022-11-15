package lotto.management;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoManagementController {

    private LottoNumberConfirm lottoNumberConfirm;
    private String purchaseMoney;

    public LottoManagementController() {
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
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseMoney);
        int lottoTickets = lottoPurchase.getNumberOfLottoTickets();
        OutputView.printLottoTickets(lottoTickets);

        LottoRandomNumber lottoRandomNumber = new LottoRandomNumber(lottoTickets);
        lottoRandomNumber.generateRandomNumbers();
        OutputView.printLottoNumbers(lottoRandomNumber.getRandomNumbers());

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(InputView.enterWinningNumbers(),
                InputView.enterBonusNumber());

        lottoNumberConfirm = new LottoNumberConfirm(lottoRandomNumber.getRandomNumbers(),
                lottoWinningNumber.getWinningNumbers(), lottoWinningNumber.getBonusNumber());
    }

    public void result() {
        lottoNumberConfirm.checkTicket();
        OutputView.printWinningTickets(lottoNumberConfirm.getTicketsResult());
        LottoWinning lottoWinning = new LottoWinning(lottoNumberConfirm.getTicketsResult(), Integer.parseInt(purchaseMoney));
        OutputView.printLottoYield(lottoWinning.getLottoYield());
    }
}
