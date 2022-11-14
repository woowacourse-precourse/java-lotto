package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.domain.constants.ErrorCode;
import lotto.domain.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아닌 값 예외 메세지 확인.")
    public void createLottoByOverSizeCheckMessage() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
        });
        assertEquals(ErrorCode.NOT_SIX_DIGITS.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 중복 예외 메세지 확인.")
    public void duplicatedNumber_exception_message_test() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 5));
        });
        assertEquals(ErrorCode.NOT_DUPLICATE.getErrorMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("로또 번호의 숫자 범위 예외 메세지 확인.")
    public void outOfRangeNumber_exception_message_test() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(0, 2, 3, 4, 5, 45));
        });
        assertEquals(ErrorCode.NOT_IN_RANGE.getErrorMessage(), exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1, 2, 3, 4, 5, 46));
        });
        assertEquals(ErrorCode.NOT_IN_RANGE.getErrorMessage(), exception.getMessage());
    }
}
