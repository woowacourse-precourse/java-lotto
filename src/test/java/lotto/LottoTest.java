package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.utils.Constant.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호에 1~45 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기능 테스트: 생성한 로또의 번호 개수가 6인지 확인한다.")
    @Test
    void createLottoTest() {
        Lotto lotto = Lotto.lottoGenerator();
        assertEquals(LOTTO_SIZE.getValue(), lotto.getNumbers().size());
    }

    @DisplayName("기능 테스트: 생성한 로또들의 총 개수가 8인지 확인한다.")
    @Test
    void createLottosTest() {
        int lottoNum = 8;
        List<Lotto> lottos = Lotto.lottosGenerator(lottoNum);
        assertEquals(lottoNum, lottos.size());
    }
}
