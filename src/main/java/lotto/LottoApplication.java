package lotto;

public class LottoApplication {

    private LottoBuyer lottoBuyer;
    private PrintController printController;

    public LottoApplication() {
        this.lottoBuyer = new LottoBuyer();
        this.printController = new PrintController();
    }

    public void run() {

        try {
            lottoBuyer.buyLotto();
            lottoBuyer.inputNumber();
            lottoBuyer.checkWinStatics();
            lottoBuyer.checkRate();
        } catch (IllegalArgumentException illegalArgumentException) {
            printController.print(illegalArgumentException.getMessage());
        }
    }


}
