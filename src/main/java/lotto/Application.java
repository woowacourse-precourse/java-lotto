package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insert(InputView.inputMoney());
        OutputView.printLottoCount(lottoMachine.getLottoCount());
        List<Lotto> lottos = lottoMachine.makeLottoTicket();
        for (Lotto lotto : lottos) {
            OutputView.printLotto(lotto.getNumbers().toString());
        }
    }
}