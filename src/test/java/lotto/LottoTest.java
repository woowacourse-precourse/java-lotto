package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class LottoTest {

    @Test
    void 로또_번호_생성_확인() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        List<Integer> result = List.of(1,2,3,4,5,6);

        assertThat(lotto.getLottoNumbers()).isEqualTo(result);
    }
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 1~45 이내가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 숫자가 아닌 다른 문자가 입력되면 예외가 발생한다.")
    @Test
    void createLottoByChar() {
        assertThatThrownBy(() -> new Lotto("1,2,3,4,5,l"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
