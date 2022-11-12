package lotto.domain;

import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    LottoMachine lottoMachine;

    public LottoMachineTest() {
    }

    @Test
    void 다섯개_로또_생성() {
        lottoMachine = new LottoMachine(5);
        lottoMachine.getLottosNumberList().stream().forEach(System.out::println);
    }

    @Test
    void 다섯개_로또_생성후_출력() {
        lottoMachine = new LottoMachine(5);
        lottoMachine.getLottosNumberList().stream().forEach(System.out::println);
    }
}
