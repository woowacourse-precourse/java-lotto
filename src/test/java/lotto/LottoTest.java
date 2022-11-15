package lotto;

import lotto.domain.Rank;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    String numbers = "[1, 2, 4, 5, 6, 7]";

    @Test
    void 로또_번호_오름차순_정렬() {
        Lotto lotto = new Lotto(List.of(7, 2, 6, 5, 1, 4));
        assertThat(lotto.numbersToString()).isEqualTo(numbers);
    }

    @Test
    void 로또_번호_모두일치시_1등() {
        Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 26));
        Rank rank = lotto.checkRank(List.of(11, 12, 13, 14, 15, 26), 17);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    void 로또_번호_5개일치_보너스1개일치_2등() {
        Lotto lotto = new Lotto(List.of(16, 2, 3, 4, 5, 1));
        Rank rank = lotto.checkRank(List.of(1, 2, 3, 4, 5, 7), 16);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }



}
