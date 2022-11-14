package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoContainer lottoContainer = lottoMachine.buy();
        lottoContainer.printLottos();
    }
}
