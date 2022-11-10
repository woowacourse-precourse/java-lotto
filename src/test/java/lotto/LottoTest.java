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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 외 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 7)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호에 1~45 외 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningByOutOfRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46), 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 출력")
    @Test
    void LottoToStringCheck() {
        String test = new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString();
        assertThat(test).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 1등 랭크 확인")
    @Test
    void LottorankCheck() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(1);
    }

    @DisplayName("당첨 2등 랭크 확인")
    @Test
    void LottoRank2Check() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(2);
    }

    @DisplayName("당첨 3등 랭크 확인")
    @Test
    void LottoRank3Check() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(3);
    }


    @DisplayName("당첨 4등 랭크 확인")
    @Test
    void LottoRank4Check() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 3, 4, 8, 7));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(4);
    }

    @DisplayName("당첨 5등 랭크 확인")
    @Test
    void LottoRank5Check() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 3, 9, 8, 7));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(5);
    }

    @DisplayName("미당첨 랭크 확인")
    @Test
    void LottoRankNoneCheck() {
        Lotto win = new Lotto(List.of(1, 2, 3, 4, 5, 6),7);
        Lotto my = new Lotto(List.of(1, 2, 10, 9, 8, 7));

        int rank = my.checkRank(win);
        assertThat(rank).isEqualTo(-1);
    }
}
