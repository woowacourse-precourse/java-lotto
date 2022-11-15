package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("로또 번호는 오름차순으로 정렬된다.")
    @Test
    void getSortedLottoNumbers() {
        Lotto lotto = new Lotto(List.of(5, 6, 1, 3, 2, 4));
        boolean actual = lotto.equals(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(actual).isTrue();
    }

    @DisplayName("로또 번호에 존재하는 숫자인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "3, true", "5, true", "7, false"})
    void isExistNumber(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean actual = lotto.isExistNumber(number);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("5개의 로또 번호가 당첨 번호와 일치한다.")
    @Test
    void countMatchingNumbers() {
        Lotto publishedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 9));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int actual = publishedLotto.countMatchingNumbers(winningLotto);

        assertThat(actual).isEqualTo(5);
    }
}
