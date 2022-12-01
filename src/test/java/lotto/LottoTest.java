package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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

    @DisplayName("로또 번호에 1부터 45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 오름차순으로 출력되는지 테스트한다.")
    @Test
    void printNumbers() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Lotto lotto = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        lotto.printSortedNumbers();

        Assertions.assertThat(output.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }

    @DisplayName("다른 로또와 같은 수만을 뽑아내는 기능을 테스트한다.")
    @Test
    void getCommonNumbers() {
        Lotto lotto1 = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 2, 1, 5, 9, 10));
        List<Integer> common = lotto1.getCommonNumbers(lotto2);
        Assertions.assertThat(common.size()).isEqualTo(4);
    }

    @DisplayName("로또에 어떤 숫자가 있는지 확인하는 기능을 테스트한다.")
    @Test
    void contains() {
        Lotto lotto = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        Assertions.assertThat(lotto.contains(1)).isEqualTo(true);
    }
}
