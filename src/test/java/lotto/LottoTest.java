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

    @DisplayName("로또 번호에 1~45 사이의 값이 아닌 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구매 금액은 1,000원 단위로 입력해야 한다.")
    @Test
    void 잘못된_금액_입력() {
        assertThatThrownBy(() -> Application.getLottoCount("3500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("알맞게 입력된 로또 금액이다.")
    @Test
    void 알맞은_금액_입력() {
        assertThat(Application.getLottoCount("3000")).isEqualTo(3);
    }

    @DisplayName("구입 금액만큼 로또가 발행되었는지 확인")
    @Test
    void 구입금액만큼_로또_발행() {
        assertThat(Application.getLottoList(4).size()).isEqualTo(4);
        assertThat(Application.getLottoList(1).size()).isEqualTo(1);
    }

    @DisplayName("구입 금액만큼 로또가 발행되었는지 확인")
    @Test
    void 당첨_로또() {
        assertThat(Application.getWinningLotto("1,2,3,4,5,6").getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }
}
