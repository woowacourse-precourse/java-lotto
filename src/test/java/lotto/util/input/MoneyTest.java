package lotto.util.input;
;
import lotto.model.Money;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {
    @Test
    void 길이가_1인_경우() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 길이가_3이고_1000의_나머지_O() {
        assertThatThrownBy(() -> new Money("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 숫자가_아닌경우() {
        assertThatThrownBy(() -> new Money("110r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 공백_1() {
        assertThatThrownBy(() -> new Money(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 공백_2() {
        assertThatThrownBy(() -> new Money(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}