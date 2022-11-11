package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호는 정렬되어있어야 한다.")
    @Test
    void sortLottoNumber() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(5, 2, 3, 4, 1, 45)));
        assertThat(lotto.getNumbers())
                .isEqualTo(new ArrayList<>(List.of(1, 2, 3, 4, 5, 45)));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
                () -> assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        );
    }
}
