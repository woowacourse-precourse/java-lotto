package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "ㄴ", "", "  ", "aa", "#", "$"})
    void 금액은_숫자만_입력이_가능합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(input))
                .withMessageContaining(Money.ERROR_MONEY_IS_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "3", "999"})
    void 금액은_최소금액보다_커야합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(input))
                .withMessageContaining(Money.ERROR_MONEY_GREATER_THAN_MIN_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "2222", "33333", "444444", "5555555", "99999999"})
    void 금액은_최소금액으로_나누어_떨어져야합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(input))
                .withMessageContaining(Money.ERROR_MONEY_DIVIDE_MIN_NUMBER);
    }
}