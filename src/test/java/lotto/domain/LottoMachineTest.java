package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import lotto.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private static LottoMachine lottoMachine;

    @DisplayName("테스트를 위해 LottoMachine 클래스를 Mocking 처리한다.")
    @BeforeAll
    public static void beforeALl() {
        lottoMachine = mock(LottoMachine.class);
    }

    @DisplayName("숫자 형식의 문자열이 아닐 때 예외기 발생한다.")
    @Test
    void testNotNumericString() throws NoSuchMethodException {
        Method checkNumericStringMethod = LottoMachine.class
                .getDeclaredMethod("checkNumericString", String.class);
        checkNumericStringMethod.setAccessible(true);

        String noNumericString = "1000j";

        assertThatThrownBy(() ->
                checkNumericStringMethod.invoke(lottoMachine, noNumericString)
        )
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }
}
