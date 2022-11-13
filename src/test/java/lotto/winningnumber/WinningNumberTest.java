package lotto.winningnumber;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.setting.WinningNumberSetting;
import org.junit.jupiter.api.Test;
import java.util.List;

public class WinningNumberTest {

    @Test
    void throwExceptionTest_whenFormNotMatched() {
        WinningNumberSetting setting = mock(WinningNumberSetting.class);
        when(setting.isValidateNumbers(anyList(), anyList())).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(List.of(1,2,3,4,5,6),List.of(7), setting);
        });
    }

    @Test
    void notThrowExceptionTest_whenFormMatched() {
        WinningNumberSetting setting = mock(WinningNumberSetting.class);
        when(setting.isValidateNumbers(anyList(), anyList())).thenReturn(true);

        assertThatCode(() -> {
            new WinningNumber(List.of(1,2,3,4,5,6),List.of(7), setting);
        }).doesNotThrowAnyException();
    }
}
