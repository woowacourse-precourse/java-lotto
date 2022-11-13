package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LottoServiceTest {

    @Nested
    @DisplayName("로또 수량 테스트")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class lottoQuantityTest {
        @ParameterizedTest
        @MethodSource("data")
        void case1(int money, int lottoQuantity) {
            LottoService lottoService = new LottoService();
            lottoService.setLotto(money);
            Assertions.assertThat(lottoQuantity).isEqualTo(lottoService.getLotto().size());
        }

        Stream<Arguments> data() {
            return Stream.of(
                    Arguments.of(1000, 1),
                    Arguments.of(10000, 10),
                    Arguments.of(123000, 123)
            );
        }
    }
}
