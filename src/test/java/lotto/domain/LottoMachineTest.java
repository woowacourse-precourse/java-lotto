package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 숫자_갯수_테스트() {
        List<Integer> result = lottoMachine.generateLottoNumber();

        System.out.println("result = " + result);
        assertThat(result).hasSize(6);
    }

    @Test
    void 숫자_범위_테스트() {
        List<Integer> result = lottoMachine.generateLottoNumber();

        assertThat(result).filteredOn(number -> number > 1 && number < 45);
    }
}