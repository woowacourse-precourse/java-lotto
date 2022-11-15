package lotto;

import lotto.core.LottoMachine;
import lotto.core.LottoMachineBuilder;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachineBuilder lottoMachineBuilder = new LottoMachineBuilder();
        LottoMachine lottoMachine = new LottoMachine(lottoMachineBuilder);
        lottoMachine.start();
    }
}
