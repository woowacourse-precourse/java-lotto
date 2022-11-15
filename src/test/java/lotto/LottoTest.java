package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 로또 번호는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 로또 번호는 서로 다른 숫자여야 합니다.");
    }
    // 아래에 추가 테스트 작성 가능
    @Test
    void 당첨번호_1범위초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, -1, 4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    void 당첨번호_45범위초과() {
        assertThatThrownBy(() -> new Lotto(List.of(1,2,46,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    @Test
    void findLottoRankingBy_적절한_LottoRanking을_반환하는지확인1() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        Lotto l = new Lotto(List.of(1,2,3,4,5,7));
        LottoRanking rank = l.findLottoRankingBy(winningLotto);
        assertThat(rank).isEqualTo(LottoRanking.SECOND_PLACE);
    }
    @Test
    void findLottoRankingBy_적절한_LottoRanking을_반환하는지확인2() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),7);
        Lotto l = new Lotto(List.of(1,2,11,12,13,14));
        LottoRanking rank = l.findLottoRankingBy(winningLotto);
        assertThat(rank).isEqualTo(LottoRanking.ETC);
    }
}
