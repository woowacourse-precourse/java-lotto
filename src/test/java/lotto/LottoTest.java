package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.*;

class LottoTest extends NsTest {
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
    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void wrongOfLottoAmount() {
        int amount = 15400;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Lotto.numberOfLottosQuantity(amount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("로또 구입 금액이 1,000원 단위로 나누어 떨어질 경우 몇 장을 구매했는지 확인한다.")
    @Test
    void rightOfLottoAmount() {
       int amount = 15000;
       assertThat(Lotto.numberOfLottosQuantity(amount)).isEqualTo(15);
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoNotMeetRequirement() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkWinning() {
        List<Integer> number = List.of(1,2,3,4,5,6,7);
        List<List<Integer>> numbers = List.of(List.of(1,2,3,8,9,10), List.of(11,12,13,14,15,16), List.of(21,22,23,24,25,28,29), List.of(31,32,33,34,37,38), List.of(17,41,42,43,44,45));
        new WinningLotto(number, numbers);
        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Override
    protected void runMain() {

    }
}
