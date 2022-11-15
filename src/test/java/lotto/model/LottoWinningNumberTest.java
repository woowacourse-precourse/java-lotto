package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.lottoticket.Lotto;
import lotto.model.lottoticket.LottoNumber;
import lotto.model.lottoticket.LottoWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {


    @DisplayName("입력한 보너스 번호 앞, 또는 뒤에 공백이 포함되어 있다면 공백 제거하고 정상 작동한다.")
    @Test
    void 보너스_입력_값_앞_뒤에_공백을_포함하고_정상적으로_값이_들어온_경우() {

        assertThat(new LottoWinningNumber(new Lotto("1,2,3,4,5,6"), new LottoNumber("   7   ")))
            .isInstanceOf(LottoWinningNumber.class);
    }

    @DisplayName("보너스 입력이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_입력이_숫자가_아닐_경우() {

        assertThatThrownBy(() -> new LottoWinningNumber(new Lotto("1,2,3,4,5,6"), new LottoNumber("a")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어나는 보너스 번호가 입력된 경우 예외가 발생한다.")
    @Test
    void 보너스_번호의_입력이_잘못된_경우() {

        assertThatThrownBy(() -> new LottoWinningNumber(new Lotto("1,2,3,4,5,6"), new LottoNumber("46")))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호를 받은 경우 예외가 발생한다.")
    @Test
    void 당첨_번호와_중복된_보너스_번호를_받은_경우_에러_유무_확인() {

        assertThatThrownBy(() -> new LottoWinningNumber(new Lotto("1,2,3,4,5,6"), new LottoNumber("6")))
            .isInstanceOf(IllegalArgumentException.class);
    }


}