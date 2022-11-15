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

    @DisplayName("로또 번호에 음수가 있으면 예외가 발생한다.")
    @Test
    void createLottoNegativeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 2, -3, -4, 5, -5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치한 번호에 따른 등수가 출력된다.")
    @Test
    void checkRank() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int firstRank = lotto.lottoChecker(List.of(1, 2, 3, 4, 5, 6), 6);
        int secondRank = lotto.lottoChecker(List.of(1, 2, 3, 4, 5, 8), 6);
        int thirdRank = lotto.lottoChecker(List.of(1, 2, 3, 4, 5, 8), 9);
        int fourthRank = lotto.lottoChecker(List.of(1, 2, 3, 4, 7, 8), 6);

        assertThat(firstRank).isEqualTo(1);
        assertThat(secondRank).isEqualTo(2);
        assertThat(thirdRank).isEqualTo(3);
        assertThat(fourthRank).isEqualTo(4);
    }

}
