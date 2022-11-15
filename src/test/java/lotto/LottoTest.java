package lotto;

import lotto.domain.Controller;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        Controller controller = new Controller();
        String input = "1000\n삼이일";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> controller.run());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복인 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedLotto() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateBonusNumber("6", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45까지의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRange() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateBonusNumber("47", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByNotNumber() {
        Controller controller = new Controller();
        String input = "1000\n1,2,3,4,5,6\n칠";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> controller.run());
    }

    @DisplayName("구입금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void inputMoneyWrongUnit() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateMoney(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 0원 이하인 경우 예외가 발생한다.")
    @Test
    void inputMoneyUnder0() {
        Utils utils = new Utils();
        assertThatThrownBy(() -> utils.validateMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void inputMoneyNotDigit() {
        String input = "천원";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Controller controller = new Controller();
        controller.run();
        assertThat(out.toString()).contains("[ERROR]");
    }
}