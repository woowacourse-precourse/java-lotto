package lotto.model.Lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("한 티켓에서 로또 당첨 갯수 세기.")
    @Test
    void countWinLottoOfTickets () {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer strikeZero = lotto.countWinLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        Integer strikeThree = lotto.countWinLotto(Arrays.asList(1, 2, 3, 13, 14, 15));
        Integer strikeAll = lotto.countWinLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        Assertions.assertEquals(strikeZero, 0);
        Assertions.assertEquals(strikeThree, 3);
        Assertions.assertEquals(strikeAll, 6);
    }
}
