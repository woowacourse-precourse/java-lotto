package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoInAscendingOrder() {
        assertThatThrownBy(() -> new Lotto(List.of(2, 1, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 로또 번호 출력 메시지 검증")
    @Test
    void checkLottoNumberPrintMessage() {

        String lottoNumberMessage = "[1, 2, 3, 4, 5, 6]";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        new Lotto(List.of(1, 2, 3, 4, 5, 6)).getNumbers();

        assertThat(out.toString().trim()).isEqualTo(lottoNumberMessage);
    }
}
