package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.domain.Lotto;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    static Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("당첨번호와 로또번호를 비교하여 몇 개가 일치하는지 알 수 있다.")
    @Test
    void getMatchingNumbers_당첨번호와_로또번호_일치하는_개수_반환() {
        assertThat(
            lotto.getMatchingNumbers(List.of(1, 10, 11, 12, 13, 14))
        ).isEqualTo(1);
        assertThat(
            lotto.getMatchingNumbers(List.of(1, 10, 6, 5, 3, 14))
        ).isEqualTo(4);
        assertThat(
            lotto.getMatchingNumbers(List.of(11, 12, 13, 14, 15, 16))
        ).isEqualTo(0);
    }

    @DisplayName("보너스와 로또번호를 비교하여 보너스번호가 포함되어 있는지 알 수 있다.")
    @Test
    void containsBonus_보너스번호가_로또번호에_포함되어_있는지_알수있다() {
        assertThat(lotto.containsBonus(10)).isFalse();
        assertThat(lotto.containsBonus(1)).isTrue();
    }

    @DisplayName("로또번호와 당첨번호 및 보너스 번호와 비교하여 당첨 내역을 알 수 있다.")
    @Test
    void compareTo_당첨번호_와_보너스번호와_비교하여_당첨내역을_구할수있다() {
        WinningRule rule = WinningRule.of(
            lotto.compareTo(List.of(1, 2, 3, 4, 5, 6), 7)
        );
        assertThat(rule.getStatus()).isEqualTo("6개 일치");
        assertThat(rule.getPrice()).isEqualTo(2_000_000_000);

        rule = WinningRule.of(
            lotto.compareTo(List.of(1, 3, 5, 14, 22, 45), 7)
        );
        assertThat(rule.getStatus()).isEqualTo("3개 일치");
        assertThat(rule.getPrice()).isEqualTo(5_000);
    }
}
