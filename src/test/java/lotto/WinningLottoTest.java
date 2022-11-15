package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복될_경우_IllegalArgumentException을_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        assertThatThrownBy(() -> new WinningLotto(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningLotto.BONUS_IS_NOT_UNIQUE_MESSAGE);
    }
}