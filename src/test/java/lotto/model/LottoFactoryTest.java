package lotto.model;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoFactoryTest {

    private static Stream<Arguments> provideMoneyAndLottoCount() {
        return Stream.of(
                Arguments.of(Money.of("1000"),1),
                Arguments.of(Money.of("2000"),2),
                Arguments.of(Money.of("5000"),5),
                Arguments.of(Money.of("10000"),10),
                Arguments.of(Money.of("1000000"),1000)
        );
    }

    @ParameterizedTest
    @DisplayName("구입 금액만큼 로또를 생성한다")
    @MethodSource("provideMoneyAndLottoCount")
    void createLottosAboutMoney(Money money, int count) {
        //given
        LottoFactory lottoFactory = new LottoFactory();
        //when
        Lottos lottos = lottoFactory.generateBy(money.calculateCount());
        //then
        Assertions.assertThat(lottos.countLottos()).isEqualTo(count);
    }
}
