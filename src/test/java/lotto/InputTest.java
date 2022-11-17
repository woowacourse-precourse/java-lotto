package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.InputController;
import domain.WinningNumber;
import resources.Error;
import controller.Validator;
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
    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void examineDivideBy1000() {
        assertSimpleTest(() -> {
            runException("12345");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("정수 외에 구입 금액은 예외가 발생한다.")
    @Test
    void isDigitPrice() {
        assertSimpleTest(() -> {
            runException("10k00e");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("9999.9");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호 입력값이 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumberSize() {
        Validator validator = new Validator();
        String[] winningNumber = {"1","2","3","4","5","6","7"};
        assertThatThrownBy(() -> validator.isCorrectSize(winningNumber,Error.SIZE))
                .isInstanceOf(IllegalArgumentException.class);
        String[] winningNumbers = {"1","2","3","4","5"};
        assertThatThrownBy(() -> validator.isCorrectSize(winningNumbers,Error.SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력할 때 쉼표로 구분해서 입력받았는지 확인")
    @Test
    void isCorrectlyEnter() {
        InputController inputController = new InputController();
        String lottoNumber = "3,6,9,12,15,18";
        InputStream input = new ByteArrayInputStream(lottoNumber.getBytes());
        System.setIn(input);
        List<Integer> testLottoNumber = Arrays.asList(3,6,9,12,15,18);
        assertThat(inputController.inputWinningNumber()).isEqualTo(testLottoNumber);
    }

    @DisplayName("당첨 번호 입력 값중 1~45 사이의 수가 아닌 숫자가 있는 경우 예외 발생한다.")
    @Test
    void createWinningNumberRange() {
        Validator validator = new Validator();
        String str[] = {"1","2","3","4","5","99"};
        assertThatThrownBy(() -> validator.isCorrectRangeNumber(str,Error.RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 문자가 있을 경우 예외가 발생한다.")
    @Test
    void createCharacterInWinningNumber() {
        Validator validator = new Validator();
        String winningNumber[] = {"1,2,3,k,4,5"};
        assertThatThrownBy(() -> validator.isNumericWinningNumber(winningNumber,Error.NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값이 1개가 아닐 경우 예외가 발생한다.")
    @Test
    void createBonusNumberSize() {
        Validator validator = new Validator();
        String bonusNumber = "1,2";
        assertThatThrownBy(() -> validator.inputOnlyOne(bonusNumber,Error.ONE_SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값이 문자일 경우 예외가 발생한다.")
    @Test
    void createCharacterInBonusNumber() {
        Validator validator = new Validator();
        String bonusNumber = "hi";
        assertThatThrownBy(() -> validator.isNumeric(bonusNumber,Error.ONE_SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값이 1~45 사이의 수가 아닌 숫자가 있는 경우 예외 발생한다.")
    @Test
    void createBonusNumberRange() {
        Validator validator = new Validator();
        String bonusNumber = "9999";
        assertThatThrownBy(() -> validator.isCorrectRange(bonusNumber,Error.ONE_SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호안에 이미 보너스 번호가 있었을 경우 예외가 발생한다.")
    @Test
    void includeBonusInWin() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        WinningNumber winningNumbers = new WinningNumber(winningNumber);
        int bonusNumber = 5;
        assertThatThrownBy(() -> winningNumbers.hasBeenBonusNumber(bonusNumber,Error.ONLY_ONE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}