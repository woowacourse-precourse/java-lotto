package lotto.domain;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @DisplayName("당첨 번호에 따른 계산 결과가 정상적이라면 그 결과를 반환한다.")
    @Test
    void computeResult_정상적인경우() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Set<Integer> winningNumbers = new HashSet<>(Set.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        Assertions.assertThat(lotto.computeResult(winningNumbers, bonusNumber)).isEqualTo(Result.SIX);
    }
}
