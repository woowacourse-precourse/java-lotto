package lotto;

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

    @DisplayName("로또 번호에 1~45 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnCorrectNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순 정렬한다.")
    @Test
    void getSortedLottoNumbers() {
        Lotto lotto = new Lotto(List.of(5, 6, 1, 3, 2, 4));
        List<Integer> sortedLottoNumbers = lotto.getSortedLottoNumbers();
        assertThat(sortedLottoNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호에 존재하는 숫자인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "3, true", "5, true", "7, false"})
    void isExistNumber(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean actual = lotto.isExistNumber(number);
        assertThat(actual).isEqualTo(expected);
    }
}
