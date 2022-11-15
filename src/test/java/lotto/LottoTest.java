package lotto;

import lotto.domain.Bonus;
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
    @DisplayName("지정 범위 이외의 숫자가 있으면 예외가 발생한다")
    @Test
    void exectionOverRange() {
        assertThatThrownBy(
            () -> new Lotto(List.of(0, 1, 2, 3, 4, 5))
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호가 구매 로또에 존재하는지 판단")
    @Test
    void is_bonusNum_in_myLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        boolean isBonusNum = Lotto.isBonus(lotto, new Bonus(6, winningLotto));
        assertThat(isBonusNum).isTrue();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되었는지 판단")
    @Test
    void is_bonusnum_duplicated_with_winningnums() {
        boolean isDuplicated = Lotto.isWinningLottoHasBouns(5,
            new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(isDuplicated).isTrue();
    }
}
