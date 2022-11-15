package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lottos 클래스의 메서드를 테스트한다.")
class LottosTest {
    @DisplayName("돈이 1000원으로 안 나눠 떨어지면 오류를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {12345, 12001, 12100, 12010})
    void ifHaveRestMoneyThrowException(int money) {
        assertThatThrownBy(() -> Lottos.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("lottos의 compareResult를 실행하면 결과값 5개(1등 ~ 5등)가 생성된다.")
    @Test
    void returnFiveWinningResultWhenCompareTenLotto() {
        //given
        Lottos lottos = Lottos.purchaseLottos(10_000);
        Result result = Result.of(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        Map<Prize, Long> winningResult = lottos.compareResult(result);

        //then
        assertThat(winningResult).hasSize(5);
    }
}