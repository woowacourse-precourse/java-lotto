package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.NotBoundLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoValueRangeTest {
    final Class<NotBoundLottoNumberException> exceptionClazz = NotBoundLottoNumberException.class;

    @DisplayName("1미만 에러")
    @Test
    public void minusErrorTest() {

        List<Integer> numbers = Arrays.asList(0);
        assertThatThrownBy(() -> LottoValueRange.validate(numbers))
                .isInstanceOf(exceptionClazz);
    }

    @DisplayName("45초과 에러")
    @Test
    public void plusErrorTest() {
        List<Integer> numbers = Arrays.asList(46);
        assertThatThrownBy(() -> LottoValueRange.validate(numbers))
                .isInstanceOf(exceptionClazz);
    }

    @DisplayName("45 작동")
    @Test
    public void correctMaxTest() {
        List<Integer> numbers = Arrays.asList(45);
        LottoValueRange.validate(numbers);
    }

    @DisplayName("1 작동")
    @Test
    public void correctMinTest() {
        List<Integer> numbers = Arrays.asList(1);
        LottoValueRange.validate(numbers);
    }
}