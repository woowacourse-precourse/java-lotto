package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    void 오름차순_정렬() {
        List<Integer> sortedList = machine.sortNumber(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(sortedList).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}