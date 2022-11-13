package lotto.domain;

import lotto.domain.Lotto;
import lotto.service.Convertor;
import lotto.status.lotto.LottoStatus;
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

    @DisplayName("숫자 범위가 1~45자리가 아닐 경우 예외가 발생한다.")
    @Test
    void createLottoByWrongRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 88)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 로또 몇개를 구입했는지 계산한다.")
    @Test
    void getQuantity() {
        //when
        String input = "8000";
        //then
        assertThat(Convertor.getQuantity(input))
                .isEqualTo(Integer.parseInt(input) / LottoStatus.eachPrice.getValue());
    }

    @DisplayName("사용자가 구입한 로또 개수에 맞춰 로또를 발행 한다.")
    @Test
    void getLottos() {
        //when
        int quantity = 8;
        //then
        assertThat(LottoGenerator.getLottos(quantity).size())
                .isEqualTo(quantity);
    }

    @DisplayName("일치 하는 번호의 개수를 반환한다.")
    @Test
    void getCountMatchingNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //then
        assertThat(lotto.getCountMatchingNumber(List.of(1,2,3,4,5,6)))
                .isEqualTo(6);
        assertThat(lotto.getCountMatchingNumber(List.of(1,2,3,4,5,7)))
                .isEqualTo(5);
    }

    @DisplayName("보너스 번호를 가지고 있는지 확인한다.")
    @Test
    void hasBonusNumber() {
        //given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        //then
        assertThat(lotto.hasNumber(1)).isEqualTo(true);
        assertThat(lotto.hasNumber(0)).isEqualTo(false);
    }
}
