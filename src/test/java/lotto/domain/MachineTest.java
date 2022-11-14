package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MachineTest {
    @Test
    @DisplayName("랜덤 숫자 6개를 가진 로또를 생성한다.")
    void createOneLottoWithoutException() {
        Machine machine = new Machine();
        assertThatCode(() -> machine.createSingleLottoTicket())
                .doesNotThrowAnyException();
    }

    /*@Test
    @DisplayName("오름차순으로 정렬된 랜덤 숫자를 생성한다")
    void createSortedRandomNumbers() {
        Machine machine = new Machine();
        List<Integer> randomNumbers = machine.createSortedRandomNumbers(1, 6, 6);
        assertThat(randomNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }*/
}
