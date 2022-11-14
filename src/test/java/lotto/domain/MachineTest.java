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
}
