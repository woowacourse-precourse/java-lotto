package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {

    private static Stream<Arguments> provideMoneyForLottoMachineTest() {
        return Stream.of(
                Arguments.of(new Money(0), 0),
                Arguments.of(new Money(1000), 1),
                Arguments.of(new Money(2000), 2),
                Arguments.of(new Money(3000), 3),
                Arguments.of(new Money(4000), 4),
                Arguments.of(new Money(5000), 5)
        );
    }

    private Money createMoney(int money) {
        return new Money(money);
    }

    @Test
    @DisplayName("로또 발행 기능 작동 테스트")
    void issueLottosTest() {
        Money money = createMoney(1000);
        Lottos lottos = LottoMachine.issueLottos(money);
        assertThat(lottos).isNotNull();
    }

    @Test
    @DisplayName("로또 발행 기능 0원 테스트")
    void issueLottosZeroMoneyTest() {
        Money money = createMoney(0);
        Lottos lottos = LottoMachine.issueLottos(money);
        assertThat(lottos.getCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @MethodSource("provideMoneyForLottoMachineTest")
    @DisplayName("로또 발행 기능 개수 테스트")
    void issueLottosSizeTest(Money money, int count) {
        Lottos lottos = LottoMachine.issueLottos(money);
        assertThat(lottos.getCount()).isEqualTo(count);
    }
}
