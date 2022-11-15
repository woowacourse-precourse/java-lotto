package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 안에 보너스 번호가 포함하는 경우")
    void isBonusNumberTrueTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("6");
        assertTrue(lotto.isBonusNumber(lottoBonusNumber));
    }

    @Test
    @DisplayName("로또 번호 안에 보너스 번호가 포함안하는 경우")
    void isBonusNumberFalseTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber("7");
        assertFalse(lotto.isBonusNumber(lottoBonusNumber));
    }

    @Test
    @DisplayName("로또 번호 일치하는 수 확인")
    void repeatLottoNumberCheck() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lottoWinningNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(6).isEqualTo(lotto.repeatLottoNumberCheck(lottoWinningNumber));
    }

    @Test
    @DisplayName("로또 번호가 없는 경우 확인")
    void validateEmptyTest() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 없습니다.");
    }

    @Test
    @DisplayName("로또 번호가 모자른 경우 확인")
    void validateCountTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 숫자가 모자릅니다.");
    }

    @Test
    @DisplayName("로또 번호가 중복인 경우 확인")
    void validateOverlapTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복 숫자가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 45보다 클 경우 확인")
    void validateNumberSizeFirstTest() {
        assertThatThrownBy(() -> new Lotto(List.of(100, 200, 300, 400, 500, 600)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호가 범위를 벗어나 너무 큽니다");
    }

    @Test
    @DisplayName("로또 번호가 1보다 작을 경우 확인")
    void validateNumberSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호가 범위를 벗어나 너무 작습니다");
    }


}
