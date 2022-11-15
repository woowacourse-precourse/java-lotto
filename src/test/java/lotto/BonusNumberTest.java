package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 맞았는지 확인한다.")
    @Test
    void lottoBonusMatch() {
        Lotto lotto1 = new Lotto(List.of(1, 7, 11, 10, 8, 9));
        BonusNumber bonusNumber = new BonusNumber(15, lotto1);
        Lotto lotto2 = new Lotto(List.of(1, 2, 8, 9, 15, 7));

        assertThat(bonusNumber.bonusMatch(lotto2)).isTrue();
    }

    @DisplayName("보너스 번호가 기존의 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void validateLottoSize() {
        Lotto lotto = new Lotto(List.of(1, 7, 11, 10, 8, 9));

        assertThatThrownBy(() -> new BonusNumber(1, lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
