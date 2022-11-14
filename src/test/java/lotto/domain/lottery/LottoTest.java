package lotto.domain.lottery;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호와 당첨 번호를 비교합니다")
    void getMatchCount() {
        Lotto lotto = new Lotto(List.of(1, 3, 7, 12, 23, 40));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 3, 7 ,9, 16, 23, 26));

        int matchCount = lotto.getMatchCount(winningNumbers);

        assertThat(matchCount)
                .isEqualTo(4);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호를 비교합니다")
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 3, 7, 12, 23, 40));
        int bonusNumber = 7;

        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

        assertThat(hasBonusNumber)
                .isEqualTo(true);
    }
}
