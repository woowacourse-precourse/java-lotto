package lotto.domain;

import static lotto.advice.ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE;
import static lotto.advice.ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.advice.BonusNumberExcption;
import lotto.advice.DuplicateExcption;
import lotto.advice.LottoNumberExcption;
import lotto.advice.LottoSizeExcption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoNumberTest {

    @DisplayName("입력받은 당첨 번호 숫자 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_개수_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5", "1"))
                .isInstanceOf(LottoSizeExcption.class)
                .hasMessage(LOTTO_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("당첨번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_중복_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5,5", "1"))
                .isInstanceOf(DuplicateExcption.class)
                .hasMessage(DUPLICATE_ERROR_MESSAGE);
    }

    @DisplayName("당첨번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 당첨_로또_번호_숫자_테스트() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,433,5,6", "3"))
                .isInstanceOf(LottoNumberExcption.class)
                .hasMessage(LOTTO_NUMBER_ERROR_MESSAGE);
    }

    @DisplayName("보너스번호가 1부터 45의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호_숫자_() {
        assertThatThrownBy(() -> new WinningLottoNumber("1,2,3,4,5,6", "a"))
                .isInstanceOf(BonusNumberExcption.class)
                .hasMessage(BONUS_NUMBER_ERROR_MESSAGE);
    }
}
