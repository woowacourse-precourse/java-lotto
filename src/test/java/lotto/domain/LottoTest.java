package lotto.domain;

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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_SIZE.getErrorMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getErrorMessage());
    }

    @DisplayName("로또 번호에 45 보다 큰 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByUnderRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
    }

    @DisplayName("로또 번호가 비어있으면 예외가 발생한다.")
    @Test
    void createLottoByEmpty() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 올바르면 정상적으로 진행된다.")
    @Test
    void createLottoByRightNumber() {
        Lotto lotto = new Lotto(List.of(1,20,30,40,45,16));
        List<Integer> lottoNumber = lotto.getNumbers();
        assertThat(lotto.getNumbers()).isEqualTo(lottoNumber);
    }
}
