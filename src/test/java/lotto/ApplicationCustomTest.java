package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("개인적으로 작성한 Application 클래스에 대한 테스트 코드")
public class ApplicationCustomTest {

    Application application = new Application();

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("인풋 검증에 관한 테스트")
    class InputValidityTest {

        Method validateInputAmountString;

        {
            try {
                 validateInputAmountString = application.getClass().getDeclaredMethod("validateInputAmountString", String.class);
                validateInputAmountString.setAccessible(true);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @ParameterizedTest(name=" invalid amountString 검증테스트 {index} : {0} ==> Exception")
        @MethodSource("testInvalidInputAmountStringArgument")
        void testInvalidInputAmountString(String inputString) {
            assertThatThrownBy(
                    () -> {
                        validateInputAmountString.invoke(application,inputString);
                    }
            );
        }

        Stream<String> testInvalidInputAmountStringArgument() {
            return Stream.of("1000s", "ABCD", "1000,", "1500", "10502", "05000");
        }

        @ParameterizedTest(name="valid amountString 검증테스트 {index} : {0} ==> Exception")
        @MethodSource("testValidInputAmountStringArgument")
        void testValidInputAmountString(String inputString) {
            assertThatNoException().isThrownBy(
                    () -> {
                        validateInputAmountString.invoke(application, inputString);
                    }
            );
        }

        Stream<String> testValidInputAmountStringArgument() {
            return Stream.of("1000", "2000", "45000", "150000"," 1000", "1000 ");
        }

    }


}
