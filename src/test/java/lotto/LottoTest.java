package lotto;

import lotto.data.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가거나 적으면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(2, 3, 4, 5, 7, 46)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(0, 3, 4, 5, 7, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성에 사용되는 번호가 정확히 6개인지 확인한다")
    @Test
    void isNumbersSizeExactlySix() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(1000, 1, 2, 3, 4, 100));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 45, 7));
        assertThat(Lotto.isNumbersSizeExactlySix(numbers)).isEqualTo(false);
    }

    @DisplayName("로또 생성에 사용되는 번호에 중복되는 번호가 없는지 확인한다")
    @Test
    void isEveryNumberDistinct() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(3, 45, 26, 28, 17, 9));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 45, 7));
        assertThat(Lotto.isEveryNumberDistinct(numbers)).isEqualTo(false);
    }

    @DisplayName("로또 생성에 사용되는 번호가 올바른 범위의 숫자인지 확인한다")
    @Test
    void isEveryNumberInRange() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(3, 45, 26, 28, 17, 9));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(true);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 46, 7));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(false);

        numbers = new ArrayList<>(List.of(7, 2, 3, 4, 5, 46, 0));
        assertThat(Lotto.isEveryNumberInRange(numbers)).isEqualTo(false);
    }
}
