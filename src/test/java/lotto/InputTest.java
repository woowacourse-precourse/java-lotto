package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.InputController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    @DisplayName("로또 구입금액이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void checkLottoPriceIsDigit() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("123.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("로또 구입금액이 1000원으로 나누어 떨어지지 않는 경우 예외 처리")
    @Test
    void checkDivideLottoPrice() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1030"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("23001"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("로또 번호 입력시 정상적으로 리스트 반환되는지 확인")
    @Test
    void checkInputStringtoList() {
        // given
        InputController inputController = new InputController();
        String lottonumber = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(lottonumber.getBytes());
        System.setIn(in);
        // when, then
        List<Integer> lottonumberlist = Arrays.asList(1,2,3,4,5,6);
        assertThat(inputController.insertLottoNumber()).isEqualTo(lottonumberlist);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
