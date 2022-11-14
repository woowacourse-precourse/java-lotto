package lotto;

import lotto.constant.Rank;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호의 개수가 6개보다 작으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45보다 큰 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberGreaterThanMax(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 46, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1보다 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByNumberLessThanMin(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, -17, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 일치할 경우 1등이라 판단한다.")
    @Test
    void testFirstRank() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,3,4,5,6), 11);
        assertThat(ticketRank.equals(Rank.FIRST));
    }

    @DisplayName("5개 일치, 보너스 볼 일치할 경우 2등이라 판단한다.")
    @Test
    void testSecondRank() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,3,4,5,9), 6);
        assertThat(ticketRank.equals(Rank.SECOND));
    }

    @DisplayName("5개 일치할 경우 3등이라 판단한다.")
    @Test
    void testThirdRank() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,3,4,5,9), 11);
        assertThat(ticketRank.equals(Rank.THIRD));
    }

    @DisplayName("4개 일치할 경우 4등이라 판단한다.")
    @Test
    void testFourthRank() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,3,4,30,31), 11);
        assertThat(ticketRank.equals(Rank.FOURTH));
    }

    @DisplayName("3개 일치할 경우 5등이라 판단한다.")
    @Test
    void testFifthRank() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,3,9,10,18), 5);
        assertThat(ticketRank.equals(Rank.FIFTH));
    }

    @DisplayName("2개 일치할 경우 꽝(nothing)이라 판단한다.")
    @Test
    void testNothingCase1() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,2,40,45,10,18), 11);
        assertThat(ticketRank.equals(Rank.NOTHING));
    }

    @DisplayName("1개 일치할 경우 꽝(nothing)이라 판단한다.")
    @Test
    void testNothingCase2() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(1,30,40,45,10,18), 11);
        assertThat(ticketRank.equals(Rank.NOTHING));
    }

    @DisplayName("0개 일치할 경우 꽝(nothing)이라 판단한다.")
    @Test
    void testNothingCase3() {
        Lotto lottoTicket = new Lotto(List.of(1,2,3,4,5,6));
        Rank ticketRank = lottoTicket.compareNumbersWith(List.of(20,21,40,45,10,18), 11);
        assertThat(ticketRank.equals(Rank.NOTHING));
    }

}
