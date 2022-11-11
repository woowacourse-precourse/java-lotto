package lotto.validate;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoValidateTest {
    private static WinLottoValidate winLottoValidate;

    @BeforeEach
    public void beforeEach() {
        winLottoValidate = new WinLottoValidate();
    }

    @Test
    public void bonusValidateTest() throws Exception {
        assertThatThrownBy(() -> winLottoValidate.bonusRangeValidate(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winLottoValidate.bonusRangeValidate(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void lottoBonusDuplicateTest() throws Exception {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winLottoValidate.validate(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}