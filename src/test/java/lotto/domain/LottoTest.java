package lotto.domain;

import lotto.utils.LottoConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 자신이 가지고 있는 수를 출력할 수 있다.")
    @Test
    void 로또_출력() {
        Lotto lotto = LottoConvertor.mapToLotto("1,2,3,4,5,6");
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString());
    }
}
