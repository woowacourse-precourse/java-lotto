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
        Method validateInputWinningNumbersString;
        Method validateInputBonusNumberString;

        {
            try {
                validateInputAmountString = application.getClass().getDeclaredMethod("validateInputAmountString", String.class);
                validateInputAmountString.setAccessible(true);

                validateInputWinningNumbersString = application.getClass().getDeclaredMethod("validateInputWinningNumbersString", String.class);
                validateInputWinningNumbersString.setAccessible(true);

                validateInputBonusNumberString = application.getClass().getDeclaredMethod("validateInputBonusNumberString", String.class);
                validateInputBonusNumberString.setAccessible(true);

            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @ParameterizedTest(name = " invalid amountString 검증테스트 {index} : {0} ==> Exception")
        @MethodSource("testInvalidInputAmountStringArgument")
        void testInvalidInputAmountString(String inputString) {
            assertThatThrownBy(
                    () -> {
                        validateInputAmountString.invoke(application, inputString);
                    }
            ).getCause().isInstanceOf(IllegalArgumentException.class);
        }

        Stream<String> testInvalidInputAmountStringArgument() {
            return Stream.of("1000s", "ABCD", "1000,", "1500", "10502", "05000");
        }

        @ParameterizedTest(name = "valid amountString 검증테스트 {index} : {0} ==> No Exception")
        @MethodSource("testValidInputAmountStringArgument")
        void testValidInputAmountString(String inputString) {
            assertThatNoException().isThrownBy(
                    () -> {
                        validateInputAmountString.invoke(application, inputString);
                    }
            );
        }

        Stream<String> testValidInputAmountStringArgument() {
            return Stream.of("1000", "2000", "45000", "150000", " 1000", "1000 ");
        }

        @ParameterizedTest(name = "invalid winningNumberString 검증테스트 {index} : {0} ==> Exception")
        @MethodSource("testInvalidInputWinningNumbersStringArgument")
        void testInvalidInputWinningNumbersString(String inputString) {
            assertThatThrownBy(() -> {
                validateInputWinningNumbersString.invoke(application, inputString);
            }).getCause().isInstanceOf(IllegalArgumentException.class);

        }

        Stream<String> testInvalidInputWinningNumbersStringArgument() {
            return Stream.of("1 2 3 4 5 6 ;", "1, 2, 3, 4, 5, 6", "a b c d e f");
        }

        @ParameterizedTest(name = "valid winningNumberString 검증테스트 {index} : {0} ==> No Exception")
        @MethodSource("testValidInputWinningNumbersStringArgument")
        void testValidInputWinningNumbersString(String inputString) {
            assertThatNoException().isThrownBy(() -> {
                validateInputWinningNumbersString.invoke(application, inputString);
            });
        }

        Stream<String> testValidInputWinningNumbersStringArgument() {
            return Stream.of("1 2 3 4 5 6", " 1 2 3 4 5 6", "1 2 3 4 5 6", "1 2 3 4");
        }

            @ParameterizedTest(name = "invalid bonusNumberString 검증테스트 {index} : {0} ==> Exception")
        @MethodSource("testInvalidInputBonusNumberStringArgument")
        void testInvalidInputBonusNumbersString(String inputString) {
            assertThatThrownBy(() -> {
                validateInputBonusNumberString.invoke(application,inputString);
            }).getCause().isInstanceOf(IllegalArgumentException.class);

        }

        Stream<String> testInvalidInputBonusNumberStringArgument() {
            return Stream.of("1;", "A", " ");
        }

        @ParameterizedTest(name = "valid bonusNumberString 검증테스트 {index} : {0} ==> No Exception")
        @MethodSource("testValidInputBonusNumberStringArgument")
            void testValidInputBonusNumberString(String inputString){
                assertThatNoException().isThrownBy(()->{
                    validateInputBonusNumberString.invoke(application,inputString);
                });
            }
            Stream<String> testValidInputBonusNumberStringArgument(){
                return Stream.of("1", " 1 "," 1");
            }


    }


}
