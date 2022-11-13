package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    void setSystemInput(String command) {
        System.setIn(new ByteArrayInputStream(command.getBytes()));
    }

    @Test
    @DisplayName("당첨번호는 로또의 숫자 개수와 같아야 한다.")
    public void inputWinningLotto_validCount() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,4,5,6,7");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호는 숫자여야 한다.")
    public void inputWinningLotto_numeric() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,ab,5,6");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 숫자여야 한다.")
    public void inputWinningLotto_bonusNumber_numeric() {
        // given
        LottoService lottoService = new LottoService();
        setSystemInput("1,2,3,4,5,6\na");
        // when
        // then
        assertThatThrownBy(lottoService::inputWinningLotto)
                .isInstanceOf(IllegalArgumentException.class);
    }
}