package lotto;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

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

    @DisplayName("로또 번호가 6개 생성되었을 때 정렬되어 생성한다.")
    @Test
    void createLottoNumbersByAscending() {
        List<Integer> numbers = new NumberGenerator().createDuplicateNumbers();
        Lotto expected = new Lotto(numbers.stream().sorted().collect(Collectors.toList()));
        assertThat(new Lotto(numbers))
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("당첨 번호가 주여졌을 때 존재하는 개수를 센다.")
    @Test
    void checkCorrectCountWinningNumbers1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);

        assertThat(lotto.countWinningNumbers(winningNumbers))
                .as("개수를 정확히 세지 못했습니다.")
                .isEqualTo(5);
    }

    @DisplayName("당첨 번호가 주여졌을 때 존재하는 개수를 센다.")
    @Test
    void checkCorrectCountWinningNumbers2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 10, 11, 12, 13);

        assertThat(lotto.countWinningNumbers(winningNumbers))
                .as("개수를 정확히 세지 못했습니다.")
                .isEqualTo(2);
    }

    @DisplayName("당첨 번호가 주여졌을 때 존재하는 개수를 센다.")
    @Test
    void checkCorrectCountWinningNumbers3() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);

        assertThat(lotto.countWinningNumbers(winningNumbers))
                .as("개수를 정확히 세지 못했습니다.")
                .isEqualTo(0);
    }
}
