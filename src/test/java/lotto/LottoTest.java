package lotto;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 1등인지 확인한다")
    @Test
    void 로또_1등() {
        //given
        int money = 3000;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        Rank lottoRank = lotto.matchRank(winningNumber, bonusNumber);
        //then
        assertThat(lottoRank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("로또가 2등인지 확인한다")
    @Test
    void 로또_2등() {
        //given
        int money = 3000;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        //when
        Rank lottoRank = lotto.matchRank(winningNumber, bonusNumber);
        //then
        assertThat(lottoRank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("로또가 낙첨인지 확인한다")
    @Test
    void 로또_낙첨() {
        //given
        int money = 3000;
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        //when
        Rank lottoRank = lotto.matchRank(winningNumber, bonusNumber);
        //then
        assertThat(lottoRank).isEqualTo(Rank.NOTHING);
    }
}
