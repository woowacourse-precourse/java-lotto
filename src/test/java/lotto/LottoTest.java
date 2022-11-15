package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("발행 로또와 당첨 로또가 매칭이 3개이하면 등수가 없다..")
    @Test
    void 매칭2개() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,44,3,7,8,9);
        int bonus = 10;
        assertEquals(lotto.compare(winningNumber, bonus), null);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 3개가 된다.")
    @Test
    void 매칭3개() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,3,7,8,9);
        int bonus = 10;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.THREE);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 보너스 포함 3개가 된다.")
    @Test
    void 매칭3개보너스포함() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,10,7,8,9);
        int bonus = 6;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.THREE);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 4개가 된다.")
    @Test
    void 매칭4개() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,3,6,8,9);
        int bonus = 10;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.FOUR);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 보너스 포함 4개가 된다.")
    @Test
    void 매칭4개보너스포함() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,3,7,8,9);
        int bonus = 6;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.FOUR);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 5개가 된다.")
    @Test
    void 매칭5개() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,3,6,5,9);
        int bonus = 10;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.FIVE);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 보너스 포함 5개가 된다.")
    @Test
    void 매칭5개보너스포함() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,10,3,5,9);
        int bonus = 6;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.FIVE);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 6개가 된다.")
    @Test
    void 매칭6개() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,3,6,5,4);
        int bonus = 10;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.SIX);
    }

    @DisplayName("발행 로또와 당첨 로또가 매칭이 보너스 포함 6개가 된다.")
    @Test
    void 매칭6개보너스포함() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        List<Integer> winningNumber = List.of(1,2,4,3,5,9);
        int bonus = 6;
        assertEquals(lotto.compare(winningNumber, bonus), Rank.BONUS);
    }
}
