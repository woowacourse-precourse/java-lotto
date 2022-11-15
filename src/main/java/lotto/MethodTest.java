package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodTest {

    @DisplayName("로또 번호 랜덤생성 테스트")
    @Test
    void createRandomLotto() {
        final Application application = new Application();
        final int price = 1000;

        final List<Integer> randomLottos = application.randomLotto();

        assertThat(randomLottos.size()).isEqualTo(6);
    }

    @DisplayName("올바른 로또 번호출력 테스트")
    @Test
    void BuyRandomLotto() {
        // given
        final Application application = new Application();
        final int price = 1000;

        // when
        final List<Integer> lotto = application.randomLotto();

        // then
        assertThat(lotto.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
    }

}
