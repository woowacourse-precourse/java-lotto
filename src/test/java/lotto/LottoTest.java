package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자로 인해 이를 제거하여 6개의 숫자가 되더라도 예외가 발생한다")
    @Test
    void createLottoValidSizeByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 번호가 로또 번호 안에 있는지 확인한다.")
    @Test
    void hasLottoNumber() {
        assertThat(new Lotto(List.of(10,9,5,1,2,3))
                .hasNumber(3)).isEqualTo(true);
    }

    @DisplayName("특정 번호가 로또 번호 안에 있는지 확인한다.")
    @Test
    void hasNoLottoNumber() {
        assertThat(new Lotto(List.of(10,9,5,1,2,3))
                .hasNumber(14)).isEqualTo(false);
    }
}
