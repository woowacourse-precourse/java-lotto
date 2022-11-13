package lotto.lottoMachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.lottomachine.LottoMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LottoMachineUserNumbersTest {

    private static final String ERROR = "[ERROR]";
    private static LottoMachine lottoMachine;
    private OutputStream out;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("로또 번호를 ,로 구별하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByWrongFormat() {
        //given
        String userInput = "1,2,3,4|5,6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputUserNumbers();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("로또 번호는 숫자로 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByNotNumber() {
        //given
        String userInput = "1,2,3,4,5,six";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputUserNumbers();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("중복된 숫자로 로또 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByDuplicateNumber() {
        //given
        String userInput = "1,2,3,4,5,5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputUserNumbers();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }

    @DisplayName("로또 번호는 6개의 숫자로 구성되지 않으면 예외가 발생한다.")
    @Test
    void inputLottoNumbersByWrongLength() {
        //given
        String userInput = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        lottoMachine.inputUserNumbers();

        // when then
        assertThat(out.toString()).contains(ERROR);
    }
}
