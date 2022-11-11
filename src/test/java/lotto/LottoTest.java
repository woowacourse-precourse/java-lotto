package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Company;
import lotto.domain.Lotto;
import lotto.service.LottoService;

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

    // 아래에 추가 테스트 작성 가능
    @DisplayName("숫자를 쉼표로 구분하지 않았을 경우 예외가 발생한다.")
    @Test
    void createLottoByNotSeparatedComma() {
        assertThatThrownBy(() -> ExceptionHandler.checkSpilt("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호가 범위 안에 있지 않을 경우 예외가 발생한다. ")
    @Test
    void createLottoOutOfLange() {
        assertThatThrownBy(() -> new Lotto(List.of(1,13,67,34,2,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoNotNumbers() {
        assertThatThrownBy(() -> LottoService.convertStringToList("a,b,c,d,e,f"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    @DisplayName("로또 번호와 보너스 번호가 일치할 경우 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new Company(List.of(1,2,3,4,5,6), 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
