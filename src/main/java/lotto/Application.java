package lotto;

import lotto.domain.LottoMachine;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.drawLotto();
    }
}
