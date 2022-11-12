package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {46, 47, 48})
    void 로또번호는_45보다_작은_숫자로_이루어져야_합니다(final Integer input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_LESS_THAN_MAX_NUMBER);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -4})
    void 로또번호는_1보다_큰_숫자로_이루어집니다(final Integer input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_GREATER_THAN_MIN_NUMBER);
    }
}