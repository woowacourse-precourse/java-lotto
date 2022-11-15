package lotto;

import lotto.constant.ExceptionMessage;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_LENGTH.getString()));
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByNotEnoughSize() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_LENGTH.getString()));
    }


    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_DUPLICATE.getString()));
    }

    @DisplayName("로또 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByTooSmallNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_RANGE.getString()));
    }

    @DisplayName("로또 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void createLottoByTooLargeNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ERROR_MESSAGE)
                        .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_RANGE.getString()));
    }

}
