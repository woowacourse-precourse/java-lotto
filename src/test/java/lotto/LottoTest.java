package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_DISTINCT_NUMBER_ERROR.getMessage());
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    @DisplayName("1 ~ 45 범위를 벗어날 시 예외처리한다.")
    public void 로또_생성_예외() throws Exception {

        //when then
        assertThatThrownBy(() -> new Lotto(List.of(235,32,442,51,36,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_LOTTO_RANGE_ERROR.getMessage());
    }
}
