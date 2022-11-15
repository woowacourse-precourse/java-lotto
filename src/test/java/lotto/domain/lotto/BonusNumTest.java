package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumTest {


    @ParameterizedTest
    @CsvSource({"1", "5", "32", "45"})
    void 숫자_범위_정상_테스트(int num) {
        new BonusNum(num);
    }

    @ParameterizedTest
    @CsvSource({"-3", "0", "46", "123"})
    void 숫자_범위_예외_테스트(int num) {
        assertThatThrownBy(() -> new BonusNum(num)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1", "5", "32", "45"})
    void isEqual_메서드_테스트(int num) {
        boolean actual = new BonusNum(num).isEqual(num);
        boolean expected = true;

        assertThat(actual).isEqualTo(expected);
    }

}