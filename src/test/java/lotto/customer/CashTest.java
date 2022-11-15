package lotto.customer;

import lotto.domain.Cash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.exception.CashExceptionMessage.WRONG_CASH_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CashTest{
    @ParameterizedTest(name = "[{index} 성공] cash = {0}")
    @MethodSource("whenCreateCashThenSuccessDummy")
    @DisplayName("현금 생성 성공 테스트")
    void whenCreateCashThenSuccess(int inputCash) {
        assertThat(new Cash(inputCash)).isNotNull();
    }

    @ParameterizedTest(name = "[{index}] [예외] cash = {0}")
    @MethodSource("whenCreateWrongCashUnitThenFailDummy")
    @DisplayName("1,000원 단위로 나눠지지 않는 현금 생성 실패 예외 처리 테스트")
    void whenCreateWrongCashUnitThenFail(int inputCash) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Cash(inputCash))
                .withMessage(WRONG_CASH_UNIT.getMessage());
    }


    static Stream<Arguments> whenCreateCashThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments("1000"),
                Arguments.arguments("2000"),
                Arguments.arguments("3000"),
                Arguments.arguments("10000"),
                Arguments.arguments("20000"),
                Arguments.arguments("30000"),
                Arguments.arguments("100000"),
                Arguments.arguments("200000"),
                Arguments.arguments("300000"),
                Arguments.arguments("111000"),
                Arguments.arguments("211000"),
                Arguments.arguments("311000"),
                Arguments.arguments("1002000")
        );
    }

    static Stream<Arguments> whenCreateWrongCashUnitThenFailDummy() {
        return Stream.of(
                Arguments.arguments("10"),
                Arguments.arguments("100"),
                Arguments.arguments("200"),
                Arguments.arguments("300"),
                Arguments.arguments("999"),
                Arguments.arguments("1001"),
                Arguments.arguments("1999"),
                Arguments.arguments("2001"),
                Arguments.arguments("12345"),
                Arguments.arguments("123456"),
                Arguments.arguments("1234567"),
                Arguments.arguments("12345678")
        );
    }

}