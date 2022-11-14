package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lottos 클래스의 메서드를 테스트한다.")
class LottosTest {
    @DisplayName("돈이 1000원으로 안 나눠 떨어지면 오류를 던진다.")
    @Test
    void ifHaveRestMoneyThrowException() {
        assertThatThrownBy(() -> Lottos.purchaseLottos(12345))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("lottos의 compareResult를 실행하면 결과값 5개가 생성된다.")
    @Test
    void compareResult() {
        //given
        Lottos lottos = Lottos.purchaseLottos(10_000);
        Result result = Result.of(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        Map<Prize, Long> winningResult = lottos.compareResult(result);

        //then
        assertThat(winningResult).hasSize(5);
    }
}