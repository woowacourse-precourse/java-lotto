package lotto;

import lotto.view.converter.ConvertMoney;
import lotto.view.converter.ConvertPlayerNumbers;
import lotto.view.converter.Converter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    Converter<String, Integer> converter1 = new ConvertMoney();
    Converter<String, List<Integer>> converter2 = new ConvertPlayerNumbers();

    @Test
    void test1() {
        int money = converter1.toNumbers("10000");
        assertThat(10000).isEqualTo(money);
    }

    @Test
    void test2() {
        assertThatThrownBy(() -> converter1.toNumbers("삼백억"))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void test3() {

        List<Integer> list = converter2.toNumbers("1,2,3,4,5,6");
        assertThat(list).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    void test4() {
        assertThatThrownBy(() -> converter1.toNumbers("one, two, three, four, five, six"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
