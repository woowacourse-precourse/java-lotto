package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void lotto_count() {
        int lottoCount = lottoMachine.getCount(2000);
        assertThat(lottoCount).isEqualTo(2);
    }

    @Test
    void lotto_buy() {
        List<Lotto> lottoList = lottoMachine.buyLotto(2000);
        assertThat(lottoList.size()).isEqualTo(2);
    }

    @Test
    void lotto_sort() {
        List<Integer> sortedList = lottoMachine.sortLotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(sortedList).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}
