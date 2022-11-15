package lotto.domain;

import org.assertj.core.api.Assertions;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("내 로또 번호와 당첨 번호가 일치하는 개수를 계산한다.")
    @Test
    void countMatchedLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        Integer bonusNumber = 10;

        LottoMatch lottoMatch = lotto.matchedCount(winningNumbers, bonusNumber);
        Assertions.assertThat(lottoMatch).isEqualTo(LottoMatch.THREE);
    }

    @DisplayName("내 로또 번호와 당첨 번호 5개가 일치하고 보너스 번호도 일치하는 지 확인한다")
    @Test
    public void checkBonusLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 9);
        Integer bonusNumber = 6;

        LottoMatch lottoMatch = lotto.matchedCount(winningNumbers, bonusNumber);
        boolean isBonus = lotto.isBonusLotto(5, bonusNumber);
        Assertions.assertThat(isBonus).isEqualTo(true);
    }
}
