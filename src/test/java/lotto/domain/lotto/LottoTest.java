package lotto.domain.lotto;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

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

    @DisplayName("로또에 해당 번호가 존재하는지")
    @Test
    void contains() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> assertThat(lotto.contains(new LottoNumber(1))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(2))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(3))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(4))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(5))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(6))).isTrue(),
                () -> assertThat(lotto.contains(new LottoNumber(10))).isFalse(),
                () -> assertThat(lotto.contains(new LottoNumber(45))).isFalse()
        );
    }

    @DisplayName("일치하는 번호 갯수 반환")
    @Test
    void getMatchCount() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 7, 8));

        int matchCount = lotto1.getMatchCount(lotto2);

        assertThat(matchCount).isEqualTo(4);
    }
}
