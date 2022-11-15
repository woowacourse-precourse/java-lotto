package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또를 다른 로또의 숫자와 비교했을 때 n개가 일치하면 getMatchedCount메소드는 n을 반환한다.")
    @Test
    void getLottoMatchedCount() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchedCount(new Lotto(List.of(1, 2, 3, 7, 8, 9)))).isEqualTo(3);
    }

    @DisplayName("로또의 toString메소드 반환값은 numbers의 수들을 (, )로 구분한 문자열이어야 한다.")
    @Test
    void convertLottoToString() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }
}