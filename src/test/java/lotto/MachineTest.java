package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MachineTest {

    Machine machine = new Machine();

    @Test
    void 로또_개수_구하기() {
        int lottoCount = machine.getCount(10000);
        Assertions.assertThat(lottoCount).isEqualTo(10);
    }

}