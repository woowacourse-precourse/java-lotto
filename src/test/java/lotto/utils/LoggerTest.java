package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import lotto.utils.Logger.LogType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LoggerTest {
    private static final String LOG_MESSAGE = "A If you can't make it good, at least make it look good.";
    private static final String NO_SUCH_METHOD_LOG_MESSAGE = "존재하지 않은 로그 타입이 전달되었습니다.";

    @DisplayName("로그 메시지가 정상적으로 출력되는지 확인한다.")
    @ParameterizedTest
    @EnumSource
    void testLog(LogType logType) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        assertSimpleTest(() -> {
            Logger.log(LOG_MESSAGE, logType);
            assertThat(out.toString())
                    .contains("[" + logType.name() + "] " + LOG_MESSAGE);
        });
    }

    @DisplayName("존재하지 않은 로그 타입일 때 예외가 발생한다.")
    @Test
    void testNoSuchEnum() throws Exception {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Logger mockLogger = mock(Logger.class);
        Method noExistLogMethod = Logger.class
                .getDeclaredMethod("log", String.class, LogType.class);
        noExistLogMethod.setAccessible(true);

        LogType mockLogType = mock(LogType.class);
        given(mockLogType.name()).willReturn("noExistMethod");

        assertThatThrownBy(() -> {
            noExistLogMethod.invoke(mockLogger, LOG_MESSAGE, mockLogType);
            assertThat(out.toString())
                    .contains("[ERROR] " + NO_SUCH_METHOD_LOG_MESSAGE);
        })
                .getCause()
                .isInstanceOf(IllegalArgumentException.class);
    }
}
