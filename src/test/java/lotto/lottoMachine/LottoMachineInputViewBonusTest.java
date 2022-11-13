package lotto.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.domain.Lotto;
import lotto.lottomachine.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineInputViewBonusTest {

    private static final String ERROR = "[ERROR]";
    private static LottoMachine lottoMachine;
    private OutputStream out;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("보너스를 숫자로 입력하지 않으면 예외가 발생한다.")
    @Test
    void InputBonusByNotNumber() {
        // given
        String userAmount = "이";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputBonus();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("보너스는 1~45가 아니면 예외가 발생한다.")
    @Test
    void InputBonusByWrongRange() {
        // given
        String userAmount = "77";
        InputStream in = new ByteArrayInputStream(userAmount.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputUserBonus();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("보너스 번호는 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void InputBonusByDuplicateNumber() {
        // given
        String userBonus = "22";
        List<Integer> userNumbers = List.of(1, 22, 23, 24, 25, 26);

        // when then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
