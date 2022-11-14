package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MachineTest {

    Machine machine;

    @BeforeEach
    void setUp() {
        machine = new Machine();
    }


    @DisplayName("로또의 개수 확인")
    @Test
    void checkNumCountLotto() {
        Lotto lotto = machine.draw();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("발행한 개수 확인")
    @Test
    void checkDrawCount() {
        int count = 10;
        List<Lotto> lottos = machine.draw(count);
        Assertions.assertThat(lottos.size()).isEqualTo(count);
    }

}
