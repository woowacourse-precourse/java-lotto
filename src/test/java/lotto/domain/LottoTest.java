package lotto.domain;

import controller.Lottery;
import domain.Lotto;
import exception.InputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Extraction;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("구매금액이 1,000단위가 아니면 예외가 발생한다.")
    @Test
    void 구매금액_1000단위_예외발생() {
        assertThatThrownBy(() -> InputException.validateInputAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 구매금액_숫자아님_예외발생() {
        assertThatThrownBy(() -> InputException.validateInputAmount("1a000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호 입력에 숫자가 아닌 문자가 입력되면 예외가 발생한다.")
    @Test
    void 당첨번호_다른문자입력_예외발생() {
        assertThatThrownBy(() -> Extraction.extractWinningNumbers("a,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_중복문자_예외발생() {
        assertThatThrownBy(() -> Extraction.extractWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 로또 번호가 허용된 범위가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_숫자범위_예외발생() {
        assertThatThrownBy(() -> Extraction.extractWinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호 입력에 숫자가 아닌 문자가 입력되면 예외가 발생한다.")
    @Test
    void 보너스번호_다른문자입력_예외발생() {
        assertThatThrownBy(() -> InputException.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 로또 번호가 허용된 범위가 아니면 예외가 발생한다.")
    @Test
    void 보너스번호_숫자범위_예외발생() {
        assertThatThrownBy(() -> InputException.validateBonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
