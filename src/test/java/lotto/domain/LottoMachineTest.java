package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import java.util.List;
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
        Method checkNumericStringMethod = LottoMachine.class.getDeclaredMethod("checkNumericString", String.class);
        checkNumericStringMethod.setAccessible(true);

        String noNumericString = "1000j";

        assertThatThrownBy(() -> checkNumericStringMethod.invoke(lottoMachine, noNumericString)).getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 번호를 숫자 형식으로 변환")
    @Test
    void testFormatStringToNumber() throws Exception {
        Method formatStringToNumberMethod = LottoMachine.class.getDeclaredMethod("formatStringToNumber", List.class);
        formatStringToNumberMethod.setAccessible(true);

        List<String> numericStrings = List.of("1", "2", "3");

        assertThat(
                formatStringToNumberMethod.invoke(lottoMachine, numericStrings))
                .isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("이미 추첨한 번호일 때 예외를 발생한다.")
    @Test
    void testAlreadyExistedNumber() throws Exception {
        Method checkAlreadyExistedNumberMethod = LottoMachine.class.getDeclaredMethod("checkAlreadyExistedNumber", List.class, int.class);
        checkAlreadyExistedNumberMethod.setAccessible(true);

        List<Integer> numbers = List.of(1, 2, 3);
        int number = 1;

        assertThatThrownBy(() -> checkAlreadyExistedNumberMethod.invoke(lottoMachine, numbers, number)).getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }
}
