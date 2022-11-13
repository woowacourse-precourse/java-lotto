package lotto;

import lotto.message.PrintController;
import lotto.service.LottoBuyService;

public class LottoApplication {

    private LottoBuyService lottoBuyService;
    private PrintController printController;

    public LottoApplication() {
        this.lottoBuyService = new LottoBuyService();
        this.printController = new PrintController();
    }

    public void run() {

        try {
            lottoBuyService.buyLotto();
            lottoBuyService.inputNumber();
            lottoBuyService.checkWinStatics();
            lottoBuyService.checkRate();
        } catch (IllegalArgumentException illegalArgumentException) {
            printController.print(illegalArgumentException.getMessage());
        }
    }


}
