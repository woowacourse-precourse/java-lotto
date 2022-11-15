package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("로또 번호가 1과 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoByInvalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("발행한 로또 티켓을 오름차순으로 정렬")
    @Test
    void sortLottoTicketByAscending() {
        assertSimpleTest(() -> {
            List<Integer> lottoTicket = Lotto.sortedLottoTicket(List.of(4,2,1,5,6,3));
            assertThat(lottoTicket).isEqualTo((List.of(1,2,3,4,5,6)));
        });
    }
}
