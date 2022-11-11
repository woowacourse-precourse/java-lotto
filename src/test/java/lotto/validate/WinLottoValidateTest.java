package lotto.validate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoValidateTest {
    private static WinLottoValidate winLottoValidate;
    @BeforeEach
    public void beforeEach(){
        winLottoValidate = new WinLottoValidate();
    }

    @Test
    public void bonusValidateTest() throws Exception{
        assertThatThrownBy(() -> winLottoValidate.bonusRangeValidate(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> winLottoValidate.bonusRangeValidate(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}