package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConfigTest {
    private static Config config;

    @DisplayName("테스트를 위해 Config 클래스를 Mocking 처리한다.")
    @BeforeAll
    public static void beforeALl() {
        config = mock(Config.class);
    }

    @DisplayName("범위 형식에 맞는 설정값일 때 정상적으로 작동되는지 확인한다.")
    @Test
    void testRangeNumber() throws Exception {
        Method checkRangeNumberMethod = Config.class
                .getDeclaredMethod("checkRangeNumber", int.class, int.class);
        checkRangeNumberMethod.setAccessible(true);

        int start = 1;
        int end = 2;

        assertSimpleTest(() -> {
            checkRangeNumberMethod.invoke(config, start, end);
        });
    }

    @DisplayName("범위 형식에 맞는 설정값이 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"2, 1", "1, 1"})
    void testNotRangeNumber(int start, int end) throws Exception {
        Method checkRangeNumberMethod = Config.class
                .getDeclaredMethod("checkRangeNumber", int.class, int.class);
        checkRangeNumberMethod.setAccessible(true);

        assertThatThrownBy(() ->
                checkRangeNumberMethod.invoke(config, start, end)
        )
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }
}
