package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    String errorTag = "[ERROR]";
    String erroMsg = "입력한 돈은 천단위의 자연수가아닙니다.";

    @DisplayName("1개 복권 살돈이 정확히 나온다.")
    @Test
    public void test() {
        Money expect = new Money("1000", 1000);
        assertThat(expect.getPayLottos()).isEqualTo(1);
    }

    @DisplayName("8개복권 살돈이 정확히 나온다.")
    @Test
    public void test2() {
        Money expect = new Money("8000", 1000);
        assertThat(expect.getPayLottos()).isEqualTo(8);
    }

    @DisplayName("천원단위가 아닌경우")
    @Test
    public void errorTest() {
        assertThatThrownBy(() -> new Money("1", 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTag)
                .hasMessageContaining(erroMsg);
    }

    @DisplayName("음수인경우")
    @Test
    public void minusMoneyTest() {
        assertThatThrownBy(() -> new Money("-1000", 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTag)
                .hasMessageContaining(erroMsg);
    }

    @DisplayName("숫자가 아닌 경우")
    @Test
    public void notNumberTest() {
        assertThatThrownBy(() -> new Money("asd", 1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorTag)
                .hasMessageContaining(erroMsg);
    }

    @DisplayName("44.44프로수익률 테스트")
    @Test
    public void halfBenefitTest() {
        String expect = new Money("9000", 1000).getBenefits(4000);
        String result = "44.44";
        assertThat(expect).isEqualTo(result);
    }

    @DisplayName("55.56% 테스트")
    @Test
    public void benefitTest() {
        String expect = new Money("9000", 1000).getBenefits(5000);
        String result = "55.56";
        assertThat(expect).isEqualTo(result);
    }
}