package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void getNumbersTest() {
        LottoSetting lottoSetting = mock(LottoSetting.class);
        when(lottoSetting.isValidNumbers(anyList())).thenReturn(true);
        Lotto lotto = new Lotto(List.of(6,5,4,3,2,1), lottoSetting);
        String excepted = "[1, 2, 3, 4, 5, 6]";

        String result = lotto.getNumbers();

        assertThat(result).isEqualTo(excepted);
    }
}
