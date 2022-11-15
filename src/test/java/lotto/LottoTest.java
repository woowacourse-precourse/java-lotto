package lotto;

import lotto.domain.Lotto;
import lotto.serviceImpl.LottoGameServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("만들어지는 로또 개수만큼 리스트가 반환되야 한다.")
    @Test
    void isUserValidLottoNumbers() {
        // given
        int input = 6;
        int expectSize = 6;
        List<Lotto> result = new LottoGameServiceImpl().makeLottoWinningNumbers(input);

        // when, then
        assertThat(result.size()).isEqualTo(expectSize);
    }
}
