package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
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

    @DisplayName("맞춘 로또 번호가 4개인 경우")
    @Test
    void win_lotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));

        assertThat(lotto.checkMatchCounts(randomLotto)).isEqualTo(4);
    }

    @DisplayName("맞춘 로또 번호가 하나도 없는 경우")
    @Test
    void lose_lotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto randomLotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));

        assertThat(lotto.checkMatchCounts(randomLotto)).isEqualTo(0);
    }
}
