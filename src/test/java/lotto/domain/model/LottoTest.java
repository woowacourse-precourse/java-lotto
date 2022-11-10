package lotto.domain.model;

import lotto.domain.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("로또 번호에 범위에 벗어나는 숫자가 있으면 예외가 발생한다. : 1보다 작은 수")
    @Test
    void createLottoByOutBoundNumberUnderZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(0, 1, 2, 3, 4, 5)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("로또 번호에 범위에 벗어나는 숫자가 있으면 예외가 발생한다. : 1보다 큰 수")
    @Test
    void createLottoByOutBoundNumberUpper45() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(0, 1, 2, 3, 4, 50)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("로또가 오름차순으로 정렬되지 않으면 예외가 발생한다.")
    @Test
    void createLottoByNotSortedByAsc(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(List.of(9, 1, 8, 3, 5, 4)));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Not Sorted by ASC.");
    }
}
