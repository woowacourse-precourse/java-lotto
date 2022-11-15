package lotto;

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

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 번호의 로또 두 개를 비교하면 같은 원소가 6이다.")
    @Test
    void compareLottosAllEquals() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(count).isEqualTo(6);
    }

    @DisplayName("1개의 원소만 다른 로또 두 개를 비교하면 같은 원소가 5이다.")
    @Test
    void compareLottosOneDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(count).isEqualTo(5);
    }

    @DisplayName("2개의 원소만 다른 로또 두 개를 비교하면 같은 원소가 4이다.")
    @Test
    void compareLottosTwoDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 2, 3, 4, 7, 8)));

        assertThat(count).isEqualTo(4);
    }

    @DisplayName("3개의 원소만 다른 로또 두 개를 비교하면 같은 원소가 3이다.")
    @Test
    void compareLottosThreeDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 2, 3, 7, 8, 9)));

        assertThat(count).isEqualTo(3);
    }

    @DisplayName("4개의 원소만 다른 로또 두 개를 비교하면 같은 원소가 2이다.")
    @Test
    void compareLottosFourDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 2, 7, 8, 9, 10)));

        assertThat(count).isEqualTo(2);
    }

    @DisplayName("5개의 원소만 다른 로또 두 개를 비교하면 같은 원소가 1이다.")
    @Test
    void compareLottosFiveDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(1, 7, 8, 9, 10, 11)));

        assertThat(count).isEqualTo(1);
    }

    @DisplayName("모든 원소가 다른 로또 두 개를 비교하면 같은 원소가 0이다.")
    @Test
    void compareLottosAllDiff() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int count = lotto.compare(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        assertThat(count).isEqualTo(0);
    }

    @DisplayName("모든 원소가 같은 정렬되지 않은 로또 두 개를 비교하면 같은 원소가 6이다.")
    @Test
    void compareLottosRandomPos() {
        Lotto lotto = new Lotto(List.of(6, 4, 2, 3, 1, 5));

        int count = lotto.compare(new Lotto(List.of(4, 3, 1, 6, 5, 2)));

        assertThat(count).isEqualTo(6);
    }
}
