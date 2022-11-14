package device.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.MockedStatic;
import java.util.List;
import java.util.stream.Stream;

public class ConsoleInputTest {

    private MockedStatic<Console> mockConsole;

    @Test
    void enterIntegerTest_normalCase() {
        given(Console.readLine()).willReturn("123");
        Integer expect = 123;

        Integer result = new ConsoleInput().enterInteger();

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void enterIntegerTest_emptyCase() {
        given(Console.readLine()).willReturn("");
        Integer expect = null;

        Integer result = new ConsoleInput().enterInteger();

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void enterIntegerTest_abnormalCase() {
        given(Console.readLine()).willReturn("12T");

        assertThrows(IllegalArgumentException.class, () -> {
            new ConsoleInput().enterInteger();
        });
    }

    @Test
    void enterIntegerListTest_normalCase() {
        given(Console.readLine()).willReturn("1,23,456,7,89,100");
        List<Integer> expect = List.of(1,23,456,7,89,100);

        List<Integer> result = new ConsoleInput().enterIntegerList();

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void enterIntegerListTest_emptyCase() {
        given(Console.readLine()).willReturn("");
        List<Integer> expect = List.of();

        List<Integer> result = new ConsoleInput().enterIntegerList();

        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest(name = "enterIntegerListTest_abnormalCase : {0}")
    @ArgumentsSource(EnterIntegerListTestAbnormalCaseData.class)
    void enterIntegerListTest_abnormalCase(String abnormalData) {
        given(Console.readLine()).willReturn(abnormalData);

        assertThrows(IllegalArgumentException.class, () -> {
            new ConsoleInput().enterIntegerList();
        });
    }

    static class EnterIntegerListTestAbnormalCaseData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("1,2,3,Y"),
                    Arguments.of("pobi"),
                    Arguments.of("12,5Y")
            );
        }
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
