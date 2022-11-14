package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.InputController;
import controller.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("로또 구입금액이 정수가 아닐 경우 예외가 발생한다.")
    @Test
    void checkLottoPriceIsDigit() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 구입금액이 1000원으로 나누어 떨어지지 않는 경우 예외 처리")
    @Test
    void checkDivideLottoPrice() {
        assertSimpleTest(() -> {
            runException("1030");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("23001");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("로또 번호 입력시 정상적으로 리스트 반환되는지 확인")
    @Test
    void checkInputStringToList() {
        // given
        InputController inputController = new InputController();
        String lottoNumber = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(lottoNumber.getBytes());
        System.setIn(in);
        // when, then
        List<Integer> testLottoNumber = Arrays.asList(1,2,3,4,5,6);
        assertThat(inputController.insertLottoNumber()).isEqualTo(testLottoNumber);
    }

    @DisplayName("로또 번호 입력값이 숫자나 쉼표가 아닐 경우 예외 발생")
    @Test
    void checkInputStringNumber() {
        InputValidator inputValidator = new InputValidator();
        String lottoNumber = "a,1,2,3,4,5";
        assertThatThrownBy(() -> inputValidator.checkDigitNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력값이 6개의 숫자가 아닐 경우 예외 발생")
    @Test
    void checkLottoNumberQuantity() {
        InputValidator inputValidator = new InputValidator();
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,6,7);
        assertThatThrownBy(() -> inputValidator.checkNumberQuantity(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 입력 값중 1~45 사이의 수가 아닌 숫자가 있는 경우 예외 발생")
    @Test
    void checkLottoNumberRange() {
        InputValidator inputValidator = new InputValidator();
        List<Integer> lottoNumber = Arrays.asList(1,2,3,4,5,46);
        assertThatThrownBy(() -> inputValidator.checkLottoNumberRange(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
