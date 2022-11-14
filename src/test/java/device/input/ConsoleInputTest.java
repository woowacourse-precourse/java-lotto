package device.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class ConsoleInputTest {

    private MockedStatic<Console> mockConsole;

    @Test
    void enterIntegerTest_normalCase() {
        given(Console.readLine()).willReturn("123");
        int expect = 123;

        int result = new ConsoleInput().enterInt();

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void enterIntegerTest_emptyCase() {
        given(Console.readLine()).willReturn("");
        Integer expect = null;

        int result = new ConsoleInput().enterInt();

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void enterIntegerTest_abnormalCase() {
        given(Console.readLine()).willReturn("12T");

        assertThrows(IllegalArgumentException.class, () -> {
            new ConsoleInput().enterInt();
        });
    }

    @BeforeEach
    void mockClass() {
        mockConsole = mockStatic(Console.class);
    }

    @AfterEach
    void closMockClass() {
        mockConsole.close();
    }
}
