package lotto.domain;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoNumber 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND, 10, 20, 30, 40, LOTTO_NUMBER_UPPER_BOUND})
    void valueOf_메서드는_범위내의_값을_입력하면_LottoNumber_인스턴스를_반환한다(int number) {
        assertThat(LottoNumber.valueOf(number)).isInstanceOf(LottoNumber.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND - 1, LOTTO_NUMBER_UPPER_BOUND + 1})
    void valueOf_메서드는_범위밖의_값을_입력하면_IllegalArgumentException을_던진다(int number) {
        assertThatThrownBy(() -> LottoNumber.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_NUMBER_LOWER_BOUND, 10, 20, 30, 40, LOTTO_NUMBER_UPPER_BOUND})
    void value_메서드는_로또_번호를_반환한다(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        assertThat(lottoNumber.value()).isEqualTo(number);
    }
}
