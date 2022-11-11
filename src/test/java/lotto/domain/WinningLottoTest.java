package lotto.domain;

import lotto.utils.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("보너스 번호는 중복되어서는 안된다.")
    @Test
    void 보너스_넘버_중복() {
        Lotto winningLotto
                = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2")
                , new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")));
        assertThatThrownBy(() -> new WinningLotto(new LottoNumber("1"), winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidator.ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("정상 동작")
    @Test
    void 정상_동작() {
        Lotto winningLotto
                = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2")
                , new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")));
        assertDoesNotThrow(() -> new WinningLotto(new LottoNumber("9"), winningLotto));
    }
}