package lotto;

import lotto.model.Lotto;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    static OutputView outputView;
    static OutputStream outputStream;

    @BeforeAll
    static void setup() {
        outputView = new OutputView();
    }

    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        initOutputStream();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        initOutputStream();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 5));
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        initOutputStream();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5));
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 번호의 값이 45보다 큰 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverLimit() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 46));
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("로또 번호의 값이 1보다 작은 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderLimit() {
        initOutputStream();
        Lotto lotto = new Lotto(List.of(0, 1, 2, 3, 4, 5));
        assertThat(outputStream.toString()).contains("[ERROR]");
    }
}
