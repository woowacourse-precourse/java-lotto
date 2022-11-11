package lotto.domain;

import lotto.utils.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")));
    }

    @DisplayName("보너스 번호는 중복되어서는 안된다.")
    @Test
    void 보너스_넘버_중복() {
        assertThatThrownBy(() -> new WinningLotto(new LottoNumber("1"), lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoValidator.ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER);
    }

    @DisplayName("정상 동작")
    @Test
    void 정상_동작() {
        assertDoesNotThrow(() -> new WinningLotto(new LottoNumber("9"), lotto));
    }

    @DisplayName("3개 미만 일치하면 FAILED")
    @Test
    void failed() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber("9"), lotto);
        Lotto userLotto = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("13"), new LottoNumber("10"), new LottoNumber("15"), new LottoNumber("16")));
        assertThat(winningLotto.makeResult(userLotto)).isEqualTo(LottoResult.FAILED);
    }

    @DisplayName("5개 일치, 보너스 숫자가 일치하면 SECOND")
    @Test
    void second() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber("9"), lotto);
        Lotto userLotto = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("9")));
        assertThat(winningLotto.makeResult(userLotto)).isEqualTo(LottoResult.SECOND);
    }

    @DisplayName("5개만 일치하면 THIRD")
    @Test
    void third() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber("9"), lotto);
        Lotto userLotto = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("8")));
        assertThat(winningLotto.makeResult(userLotto)).isEqualTo(LottoResult.THIRD);
    }

    @DisplayName("6개가 일치하면 FIRST")
    @Test
    void first() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber("9"), lotto);
        Lotto userLotto = new Lotto(List.of(new LottoNumber("1"), new LottoNumber("2"), new LottoNumber("3"), new LottoNumber("4"), new LottoNumber("5"), new LottoNumber("6")));
        assertThat(winningLotto.makeResult(userLotto)).isEqualTo(LottoResult.FIRST);
    }
}