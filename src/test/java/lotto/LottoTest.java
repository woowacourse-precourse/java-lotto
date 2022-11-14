package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호 범위 1~45를 넘어가는 숫자가 있으면 예외가 발생한다. - 범위보다 큰 경우")
    @Test
    void createLottoByOutOfRangeNumber1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 범위 1~45를 넘어가는 숫자가 있으면 예외가 발생한다. - 범위보다 작은 경우")
    @Test
    void createLottoByOutOfRangeNumber2() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다. - 5개인 경우")
    @Test
    void createLottoByUnderSize5() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다. - 4개인 경우")
    @Test
    void createLottoByUnderSize4() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다. - 3개인 경우")
    @Test
    void createLottoByUnderSize3() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다. - 2개인 경우")
    @Test
    void createLottoByUnderSize2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다. - 1개인 경우")
    @Test
    void createLottoByUnderSize1() {
        assertThatThrownBy(() -> new Lotto(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
