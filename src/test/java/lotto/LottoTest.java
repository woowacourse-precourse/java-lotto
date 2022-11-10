package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45이외의 번호가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBound() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외 메세지가 출력한다.")
    @Test
    void createLottoByOverSizeForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 6개입니다.");
    }
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createLottoByUnderSizeForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 6개입니다.");
    }
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 메세지를 출력한다.")
    @Test
    void createLottoByDuplicatedNumberForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
    @DisplayName("로또 번호에 1~45이외의 번호가 있으면 예외 메세지를 출력한다.")
    @Test
    void createLottoByOutOfBoundForPrint() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(out.toString()).isEqualTo("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }

}
