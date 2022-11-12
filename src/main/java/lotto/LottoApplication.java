package lotto;

public class LottoApplication {

    private LottoBuyer lottoBuyer;

    public LottoApplication() {
        this.lottoBuyer = new LottoBuyer();
    }

    public void run() {


        lottoBuyer.buyLotto();
        lottoBuyer.checkWinStatics();
        lottoBuyer.checkRate();

    }


}
