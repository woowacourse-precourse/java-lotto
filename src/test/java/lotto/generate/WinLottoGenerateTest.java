package lotto.generate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinLottoGenerateTest {
    @Test
    public void winNumberInputValidateTest() throws Exception{
        assertThatThrownBy(() ->new WinLottoGenerate().winNumberValidate("1400a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void bonusInputValidateTest() throws Exception{
        assertThatThrownBy(() ->new WinLottoGenerate().winNumberValidate("14e"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}