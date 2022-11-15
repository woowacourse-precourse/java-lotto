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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 번호가 입력 번호와 6개 일치하면 1등이다")
    @Test
    void create1stPrize() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 4, 5, 6), 7))
                .isEqualTo(Prize.FIRST);
    }
    @DisplayName("로또 번호가 입력 번호와 5개 일치하고 보너스 번호 일치하면 2등이다")
    @Test
    void create2stPrize() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 4, 5, 8), 8))
                .isEqualTo(Prize.SECOND);
    }
    @DisplayName("로또 번호가 입력 번호와 5개 일치하면 3등이다")
    @Test
    void create3stPrize() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 4, 5, 8), 7))
                .isEqualTo(Prize.THIRD);
    }
    @DisplayName("로또 번호가 입력 번호와 4개 일치하면 4등이다")
    @Test
    void create4stPrize() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 4, 8, 9), 7))
                .isEqualTo(Prize.FOURTH);
    }
    @DisplayName("로또 번호가 입력 번호와 3개 일치하면 5등이다")
    @Test
    void create5stPrize() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 8, 9, 10), 7))
                .isEqualTo(Prize.FIFTH);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void createBonusByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))
                .raffle(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
