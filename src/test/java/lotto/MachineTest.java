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

    @DisplayName("일치하는 번호 개수 확인 - 모두 일치 하는 경우")
    @Test
    void compareLottoCorrectAll() {
        int count = machine.compare(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        Assertions.assertThat(count).isEqualTo(6);
    }

    @DisplayName("일치하는 번호 개수 확인 - 하나만 일치 하는 경우")
    @Test
    void compareLottoCorrectOne() {
        int count = machine.compare(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(6, 7, 8, 9, 10, 11)));

        Assertions.assertThat(count).isEqualTo(1);
    }

}

