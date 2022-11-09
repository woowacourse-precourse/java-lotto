package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void wrongOfLottoAmount() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.numberOfLottosQuantity(15400))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어질 경우")
    @Test
    void rightOfLottoAmount() {
       int amount = 15000;
       assertThat(Lotto.numberOfLottosQuantity(amount)).isEqualTo(15);
    }
}
