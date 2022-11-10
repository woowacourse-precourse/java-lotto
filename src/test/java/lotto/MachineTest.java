package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MachineTest {

    Machine machine = new Machine();

    @Test
    void 로또_개수_구하기() {
        int lottoCount = machine.getCount(10000);
        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    void 로또_구매() {
        List<Lotto> lottoList = machine.buy(5000);
        assertThat(lottoList.size()).isEqualTo(5);
    }

}