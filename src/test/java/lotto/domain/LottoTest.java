package lotto.domain;

import lotto.utils.LottoConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_DUPLICATE_NUMBER);
    }

    @DisplayName("로또는 자신이 가지고 있는 수를 출력할 수 있다.")
    @Test
    void 로또_출력() {
        Lotto lotto = LottoConvertor.mapToLotto("1,2,3,4,5,6");
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString());
    }

    @DisplayName("로또는 1미만의 수를 가질 수 없다.")
    @Test
    void 로또_1미만의_수_불가() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
    }

    @DisplayName("로또는 45초과의 수를 가질 수 없다.")
    @Test
    void 로또_45초과의_수_불가() {
        assertThatThrownBy(() -> LottoConvertor.mapToLotto("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER);
    }

    @DisplayName("두 로또를 비교해 일치 개수를 반환한다.")
    @Test
    void 일치_개수_반환() {
        Lotto lotto = LottoConvertor.mapToLotto("1,2,3,4,5,6");
        Lotto winningLotto = LottoConvertor.mapToLotto("1,2,3,4,35,36");
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(4);
    }

    @DisplayName("로또에 해당 번호 존재하는지 확인한다.")
    @Test
    void 존재_여부_반환() {
        Lotto lotto = LottoConvertor.mapToLotto("1,2,3,4,5,6");
        LottoNumber lottoNumber = LottoConvertor.mapToLottoNumber("1");
        assertTrue(lotto.contain(lottoNumber));
    }
}
