package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoPurchaseValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidLottoBuyingMoney")
    @DisplayName("유효하지 않은 구매 금액 입력 시 예외 발생")
    public void validate(final String buyingAMount) {
        final var sut = new LottoPurchaseValidator();

        final Exception exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                sut.validate(buyingAMount);
            }
        );

        assertEquals("[ERROR] 구매 금액은 21억원 이하의 1000 단위의 자연수만 허용됩니다.", exception.getMessage());
    }

    static Stream<Arguments> invalidLottoBuyingMoney() throws Throwable {
        return Stream.of(
            Arguments.of("-1"),
            Arguments.of("0"),
            Arguments.of("900"),
            Arguments.of("1010"),
            Arguments.of("2147483647") // int maxvalue + 1
        );
    }
}
