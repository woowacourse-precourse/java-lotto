package lotto;

import lotto.converter.ConvertMoney;
import lotto.converter.ConvertPlayerNumbers;
import lotto.converter.Converter;
import lotto.validation.MoneyValidation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    Converter<String, Integer> converter1 = new ConvertMoney();
    Converter<String, List<Integer>> converter2 = new ConvertPlayerNumbers();

    @Test
    void test1() {
        assertThatThrownBy(() -> converter1.toNumbers("10000"))
                .doesNotThrowAnyException();
    }

    @Test
    void test2() {
        assertThatThrownBy(() -> converter1.toNumbers("삼백억"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test3() {

        List<Integer> list = converter2.toNumbers("1,2,3,4,5,6");
        assertThat(list).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void test4() {
        assertThatThrownBy(() -> converter1.toNumbers("one, two, three, four, five, six"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
