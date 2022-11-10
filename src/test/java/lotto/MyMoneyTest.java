package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyMoneyTest {
    @Test
    void 올바른_금액_테스트() {
        MyMoney testCorrect = new MyMoney("12000");
        assertThat(testCorrect.getAmount()).isEqualTo(12000);
    }

    @Test
    void 숫자가_아닌_문자가_포함될때() {
        assertThatThrownBy(() -> new MyMoney("12345굿"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백이_들어올때() {
        assertThatThrownBy(() -> new MyMoney(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천의_배수가_아닐때() {
        assertThatThrownBy(() -> new MyMoney("12345"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수가_들어올때() {
        assertThatThrownBy(() -> new MyMoney("-23000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영으로_시작하는_숫자가_들어올때() {
        assertThatThrownBy(() -> new MyMoney("03000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중간에_공백이_있을때() {
        assertThatThrownBy(() -> new MyMoney("3 000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
