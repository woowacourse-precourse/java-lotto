package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    @DisplayName("만들어진 로또 번호가 오름차순이 아니라면 예외를 던진다")
    void ifCreatedLottoIsNotAscendingThenExceptionIsThrown() {
        // given
        List<Integer> numbers = new ArrayList<>();
        for (int quantity = 0; quantity < LottoNumber.NUMBER_OF_LOTTO_NUMBERS.getNumber(); quantity++) {
            numbers.add(LottoNumber.END_NUMBER_OF_LOTTO.getNumber() - quantity);
        }

        // when
        Lotto lotto = new Lotto(numbers);
        Collections.reverse(numbers);

        // then
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }
}
