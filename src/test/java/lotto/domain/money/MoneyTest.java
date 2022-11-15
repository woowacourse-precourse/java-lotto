package lotto.domain.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoneyTest {

    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "ㄴ", "", "  ", "aa", "#", "$"})
    void 금액은_숫자만_입력이_가능합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.generatePurchaseLottoMoney(input))
                .withMessageContaining(Money.ERROR_MONEY_IS_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1", "2", "3", "999"})
    void 금액은_최소금액보다_커야합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.generatePurchaseLottoMoney(input))
                .withMessageContaining(Money.ERROR_MONEY_GREATER_THAN_MIN_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "2222", "33333", "444444", "5555555", "99999999"})
    void 금액은_최소금액으로_나누어_떨어져야합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.generatePurchaseLottoMoney(input))
                .withMessageContaining(Money.ERROR_MONEY_DIVIDE_MIN_NUMBER);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "10000000:7555000:75.6",
            "10000:0:0.0",
            "8000:5000:62.5",
            "10000:1000:10.0",
            "10000:4000:40.0",
            "20000:3000:15.0",
            "700000:5000:0.7",
            "10000:20000000000000000:200000000000000.0"
    }, delimiterString = ":")
    void 금액의_수익률을_구할_수_있습니다(final Long principleInput, final Long profitInput, final Double percentInput) {
        var principle = Money.generateMoney(principleInput);
        var profit = Money.generateMoney(profitInput);

        var actual = principle.calculateROI(profit);
        Assertions.assertThat(actual).isEqualTo(percentInput);
    }
}