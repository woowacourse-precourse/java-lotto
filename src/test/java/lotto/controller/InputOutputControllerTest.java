package lotto.controller;

import lotto.domain.lottomachine.error.InputErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputOutputControllerTest {
    private InputOutputController inputOutputController;

    @BeforeEach
    void setUp() {
        inputOutputController = new InputOutputController();
    }

    @DisplayName("validateForm 메소드에 입력된 input이 InputErrorMessage의 정규식과 맞지 않을 때 오류를 발생시키는지 확인")
    @ParameterizedTest()
    @MethodSource("provideArgumentsForValidationTest")
    void validateForm_error_test(String input, InputErrorMessage value) throws NoSuchMethodException, IllegalAccessException {
        Method method = inputOutputController.getClass().getDeclaredMethod("validateForm", String.class, InputErrorMessage.class);
        method.setAccessible(true);

        try {
            method.invoke(inputOutputController, input, value);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(value.getErrorMessage());
        }
    }

    static Stream<Arguments> provideArgumentsForValidationTest() {
        return Stream.of(
                Arguments.of("123", InputErrorMessage.PAYMENT),
                Arguments.of("1234r", InputErrorMessage.PAYMENT),
                Arguments.of("[1.2,3,4,5,6]", InputErrorMessage.WINNING_NUMBERS),
                Arguments.of("[1,52,3,4,5,6]", InputErrorMessage.WINNING_NUMBERS),
                Arguments.of("{1,2,3,4,5,6}", InputErrorMessage.WINNING_NUMBERS),
                Arguments.of("123", InputErrorMessage.BONUS_NUMBER),
                Arguments.of("12r", InputErrorMessage.BONUS_NUMBER)
        );
    }
}