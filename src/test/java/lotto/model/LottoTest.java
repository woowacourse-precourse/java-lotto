package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    String numbers = "[1, 2, 3, 4, 5, 6]";

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

    @DisplayName("로또 번호에 보너스 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByLottoNumbers() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.validateBonusNumber(1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입한 로또의 문자열은 지정한 문자열 형태를 반환해야 한다.")
    @Test
    void checkLottoString() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.numbersToString()).isEqualTo(numbers);
    }

    @DisplayName("구입한 로또는 오름차순 정렬로 저장되야 한다.")
    @Test
    void createLottoByUnsorted() {
        Lotto lotto = new Lotto(List.of(2, 6, 1, 4, 5, 3));
        assertThat(lotto.numbersToString()).isEqualTo(numbers);
    }

    @DisplayName("번호가 모두 일치하면 1등이어야 한다.")
    @Test
    void createFirstRankLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.checkRank(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("번호5개와 보너스번호가 일치하면 2등이어야 한다.")
    @Test
    void createSecondRankLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Rank rank = lotto.checkRank(List.of(1, 2, 3, 4, 5, 7), 6);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
