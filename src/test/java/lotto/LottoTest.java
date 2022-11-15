package lotto;

import lotto.domain.Lotto;
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
    @DisplayName("5개를 맞추고 보너스는 못맞췄으면 3를 반환한다.")
    @Test
    void getRankByFiveSameNumberWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 9), 7);

        assertThat(rank).isEqualTo(3);
    }

    @DisplayName("5개를 맞추고 보너스를 맞췄으면 2를 반환한다")
    @Test
    void getRankByFiveSameNumberWithoutBouus() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 9), 7);

        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("2개를 맞추고 보너스를 맞췄으면 0을 반환한다")
    @Test
    void getNonRankByTwoSameNumberWithBonus() {
        Lotto lotto = new Lotto(List.of(1, 2, 13, 14, 15, 7));
        int rank = lotto.draw(List.of(1, 2, 3, 4, 5, 9), 7);

        assertThat(rank).isEqualTo(0);
    }
}
