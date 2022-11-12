package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    void 보너스_번호가_로또_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
            BonusNumber bonusNumber = new BonusNumber(1);
            new WinningLotto(lotto, bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
    }
}