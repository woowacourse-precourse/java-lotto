package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @DisplayName("보너스 번호가 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicateBonusNumber() {
        assertThatThrownBy(() -> {
            final byte[] buf = String.join("\n", "1,2,3,4,5,6","6").getBytes();
            System.setIn(new ByteArrayInputStream(buf));
            WinningLotto.create();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}