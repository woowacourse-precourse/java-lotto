package lotto;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.lotto.Lotto;
import lotto.setting.LottoSetting;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LottoUnitTest {

    @Test
    void throwExceptionTest_whenFormNotMatched() {
        LottoSetting lottoSetting = mock(LottoSetting.class);
        when(lottoSetting.isValidNumbers(anyList())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> {
            new Lotto(List.of(1,2,3,4,5,6), lottoSetting);
        });
    }

    @Test
    void notThrowExceptionTest_whenFormMatched() {
        LottoSetting lottoSetting = mock(LottoSetting.class);
        when(lottoSetting.isValidNumbers(anyList())).thenReturn(true);

        assertThatCode(() -> {
            new Lotto(List.of(1,2,3,4,5,6), lottoSetting);
        }).doesNotThrowAnyException();
    }
}
