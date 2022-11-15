package lotto.view;

import lotto.view.input.Input;
import lotto.view.input.InputImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    @Test
    @DisplayName("투입금액 테스트 성공")
    void case1() {
        //given
        Input input = new InputImpl();

        //when
        String userInput = "4000";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        String result = input.moneyInput();

        //then
        assertThat(result).isEqualTo(userInput);
    }

    @Test
    @DisplayName("투입금액 테스트 실패 : 숫자가 아닐 경우")
    void case2() {
        //given
        Input input = new InputImpl();

        //when
        String userInput = "ftftf";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::moneyInput).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("투입금액 테스트 실패 : 투입 금액의 단위가 1,000 단위가 아닐 경우")
    void case3() {
        //given
        Input input = new InputImpl();

        //when
        String userInput = "1111";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::moneyInput).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("당첨 번호 입력 성공")
    void case4() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);
        String result = input.winningNumbersInput();

        //then
        assertThat(result).isEqualTo(systemInput);
    }

    @Test
    @DisplayName("당첨 번호 입력 실패: ',' 로 구분되지 않는 당첨 번호 입력")
    void case5() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "1.2.3.4.5.6";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);
        //then
        assertThatThrownBy(input::winningNumbersInput).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 실패: 쉼표로 구분된 6개의 숫자가 아닌경우")
    void case6() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::winningNumbersInput).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력 실패: 숫자가 1~45 사이의 숫자가 아닌 경우가 있는 경우")
    void case7() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "1,100,3,4,5";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::winningNumbersInput).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 입력 성공")
    void case8() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "23";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);

        //then
        assertThat(input.BonusNumberInput()).isEqualTo(systemInput);
    }

    @Test
    @DisplayName("보너스 번호 입력 실패 : 숫자가 아닌 입력을 할 경우")
    void case9() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "dfds";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::BonusNumberInput).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("보너스 번호 입력 실패 : 1~45 사이의 숫자를 입력하지 않은 경우")
    void case10() {
        //given
        Input input = new InputImpl();

        //when
        String systemInput = "111111111";
        InputStream in = new ByteArrayInputStream(systemInput.getBytes());
        System.setIn(in);

        //then
        assertThatThrownBy(input::BonusNumberInput).isInstanceOf(IllegalArgumentException.class);

    }
}
