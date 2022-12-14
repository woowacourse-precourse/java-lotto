package lotto.domain;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자 범위는 1부터 45까지이다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(2, 0, 5, 6, 7, 8)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호끼리의 중복 개수 확인")
    @Test
    void countMatch() {
        //given
        ArrayList<Integer> ticketNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto ticket = new Lotto(ticketNumbers);
        ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(9, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(winningNumbers);

        //when
        Integer matchCount = ticket.countMatch(winning);

        //then
        Assertions.assertThat(matchCount).isEqualTo(5);
    }
}
