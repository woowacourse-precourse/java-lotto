package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
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

    @DisplayName("로또 번호가 1부터 45까지 범위에 있지 않으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 출력된다.")
    @Test
    void printLotto() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.printNumbers();

        String expected = "[1, 2, 3, 4, 5, 6]";
        assertThat(output.toString().contains(expected)).isEqualTo(true);

        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("로또 번호 중 당첨 번호에 있는 개수를 파악한다.")
    @Test
    void calculateWinningCount() {
        int expected = 3;

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6,7);
        Lotto lotto = new Lotto(List.of(1,2,3,14,15,16));

        int winningCount = lotto.calculateWinningCount(winningNumbers);
        assertThat(winningCount).isEqualTo(expected);
    }
}
