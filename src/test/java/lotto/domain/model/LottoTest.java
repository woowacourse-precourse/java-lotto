package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 번호는 총 6개여야 합니다.");
        ;
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또번호가 범위에 맞지 않는 경우")
    @Test
    void CHECK_LOTTO_RANGE() {

        assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 99)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 0, 45)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
                () -> assertThatThrownBy(() -> new Lotto(List.of(-1, 2, 3, 4, 0, 45)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        );
    }

}
