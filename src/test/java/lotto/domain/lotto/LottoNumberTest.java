package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_LESS_THAN_MAX_NUMBER);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(String.valueOf(input)))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_LESS_THAN_MAX_NUMBER);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -4})
    void 로또번호는_1보다_큰_숫자로_이루어집니다(final Integer input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_GREATER_THAN_MIN_NUMBER);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(String.valueOf(input)))
                .withMessageContaining(LottoNumber.ERROR_NUMBER_GREATER_THAN_MIN_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또번호는_값만_같은면_같은_숫자입니다(final Integer input) {
        var original = new LottoNumber(input);
        var target = new LottoNumber(input);

        Assertions.assertThat(original).isEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또번호는_값이_다르면_다른_값입니다(final Integer input) {
        var original = new LottoNumber(input);
        var target = new LottoNumber(input + 1);

        Assertions.assertThat(original).isNotEqualTo(target);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ㄱ", "ㄴ", "a", "###", "$", "@"})
    void 로또번호는_정수가_아닌값을_입력받을_수_없습니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input))
                .withMessageContaining(LottoNumber.ERROR_INPUT_IS_NUMBER);
    }
}