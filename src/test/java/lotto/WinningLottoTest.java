package lotto;

import lotto.domain.lotto.BonusBall;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.global.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("보너스 번호가 당첨번호에 이미 포함되어 있다면 예외가 발생한다.")
    void createWinningLotto() {
        //given
        final Lotto lotto = Lotto.create(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        final BonusBall bonusBall = BonusBall.create(6);

        //when %% then
        assertThatThrownBy(() -> WinningLotto.create(lotto, bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER);
    }
}
