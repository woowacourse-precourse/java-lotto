package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserLottosTest {

    @DisplayName("유효하지 않은 돈을 입력했을 때,예외 발생한다.")
    @ParameterizedTest
    @ValueSource (ints = {1,1005,1500,2300,5000005})
    void validateMoneyTest(int money) {
        assertThatThrownBy(() -> new UserLottos(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액에 해당하는 개수만큼 로또 생성하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideUserLottosWithMoney")
    void getLottoCount(UserLottos userLottos, int expected) {
        assertThat(userLottos.getLottoCount()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideUserLottosWithMoney() {
        return Stream.of(
            Arguments.of(new UserLottos(5000), 5),
            Arguments.of(new UserLottos(10000), 10),
            Arguments.of(new UserLottos(1000), 1),
            Arguments.of(new UserLottos(8000), 8)
        );
    }
}
