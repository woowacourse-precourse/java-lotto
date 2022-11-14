package lotto.infra.log;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LoggerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @DisplayName("예외 메세지를 남긴 후 지정한 예외를 발생시킨다.")
    @Test
    void errorLogWithAssignException() {
        // given
        final Logger log = new Logger();
        final String message = "sample exception message";

        // when, then
        assertThatThrownBy(() -> log.error(message, IllegalArgumentException.class))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(outContent.toString()).contains("[ERROR]");
    }
}