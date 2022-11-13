package lotto;

public class LottoApplication {

    private LottoBuyer lottoBuyer;

    public LottoApplication() {
        this.lottoBuyer = new LottoBuyer();
    }

    public void run() {

        try {
            lottoBuyer.buyLotto();
            lottoBuyer.inputNumber();
            lottoBuyer.checkWinStatics();
            lottoBuyer.checkRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
