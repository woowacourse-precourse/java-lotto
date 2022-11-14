package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Machine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class MachineTest {

    @DisplayName("로또의 개수 확인")
    @Test
    void checkNumCountLotto() {
        Machine machine = new Machine();
        Lotto lotto = machine.draw();
        List<Integer> numbers = lotto.getNumbers();
        Assertions.assertThat(numbers.size()).isEqualTo(6);
    }


}
