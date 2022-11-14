package lotto;

import lotto.domain.Lotto;
import lotto.model.ContainStatus;
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

    @Test
    void 숫자_포함_여부_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int n = 1;
        int k = 7;
        assertThat(lotto.isContainNumber(n)).isEqualTo(ContainStatus.Contain);
        assertThat(lotto.isContainNumber(k)).isEqualTo(ContainStatus.NotContain);
    }

    @Test
    void 당첨갯수_확인() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getMatchingNumber(user)).isEqualTo(6);
    }

    // 아래에 추가 테스트 작성 가능
}
