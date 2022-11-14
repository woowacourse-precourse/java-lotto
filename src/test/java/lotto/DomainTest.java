package lotto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class DomainTest {

    @Test
    @DisplayName("입력이공백인경우")
    void inputMoneyException() {
        String input = "";
        Domain domain = new Domain();
        assertThatThrownBy(() -> {
            domain.inputMoneyException(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로만 입력하십시오.");
    }

    @Test
    @DisplayName("입력이문자인경우")
    void inputMoneyException2() {
        String input = "ㅁ1챠ㅐㅈ";
        Domain domain = new Domain();
        assertThatThrownBy(() -> {
            domain.inputMoneyException(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로만 입력하십시오.");
    }

    @Test
    @DisplayName("음수를입력했을경우")
    void inputMoneyException3() {
        String input = "-10000";
        Domain domain = new Domain();
        assertThatThrownBy(() -> {
            domain.inputMoneyException(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자로만 입력하십시오.");
    }

    @Test
    @DisplayName("1000원단위입력안할시")
    void inputMoneyException4() {
        String input = "12452";
        Domain domain = new Domain();
        assertThatThrownBy(() -> {
            domain.inputMoneyException(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 단위의 금액을 입력하십시오.");
    }

}