package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insert(InputView.inputMoney());
        OutputView.printLottoCount(lottoMachine.getLottoCount());
        lottoMachine.makeLottoTicket();
    }
}
