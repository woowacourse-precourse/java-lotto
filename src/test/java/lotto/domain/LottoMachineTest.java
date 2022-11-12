package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@Nested
class LottoMachineTest {

    @Nested
    @DisplayName("입력받은 로또 개수는")
    class LottoMachineInputValueTest {
        @Test
        @DisplayName("1개면 1개의 로또를 반환한다")
        void test1() {
            LottoMachine machine = LottoMachine.init();
            List<Lotto> lottos = machine.makeLottoes(1);
            Assertions.assertThat(lottos.size()).isEqualTo(1);
        }

        @Test
        @DisplayName("1개보다 작으면 예외를 반환한다")
        void test2() {
            LottoMachine machine = LottoMachine.init();
            Assertions.assertThatThrownBy(() ->
                            machine.makeLottoes(0))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}