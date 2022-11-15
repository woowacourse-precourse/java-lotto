package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.Cashier;

class CashierTest {

    @DisplayName("캐셔가 받는 금액에 음수의 금액이 들어가면 에러를 발생한다.")
    @Test
    void inputPlayerMoneyByNegativeNumber() {
        assertThatThrownBy(() -> new Cashier().inputPlayerMoney("-1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 받는 금액이 1000원 단위로 떨어지지않으면 에러를 발생한다.")
    @Test
    void inputPlayerMoneyByNotDivided1000() {
        assertThatThrownBy(() -> new Cashier().inputPlayerMoney("1020"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 기록하는 정답 로또번호는 6자리보다 크면 에러를 발생한다.")
    @Test
    void inputPlayerAnswerNumberByOverSize() {
        assertThatThrownBy(() -> new Cashier().inputPlayerAnswerNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 기록하는 정답 로또번호는 6자리보다 작으면 에러를 발생한다.")
    @Test
    void inputPlayerAnswerNumberByLowSize() {
        assertThatThrownBy(() -> new Cashier().inputPlayerAnswerNumber(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 기록하는 정답 로또번호는 각 자리수가 1~45 범위가 아니라면 에러를 발생한다.")
    @Test
    void inputPlayerAnswerNumberByOverRange() {
        assertThatThrownBy(() -> new Cashier().inputPlayerAnswerNumber(List.of(1, 2, 3, 4, 5, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 기록하는 정답 로또번호는 보너스번호와 중복되면 에러를 발생한다.")
    @Test
    void inputPlayerBonusNumberByDuplicatedAnswerNumbers() {
        assertThatThrownBy(() -> new Cashier().inputPlayerBonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("캐셔가 기록하는 보너스번호는 1~45 범위가 아니라면 에러를 발생한다.")
    @Test
    void inputPlayerBonusNumberByOverRange() {
        assertThatThrownBy(() -> new Cashier().inputPlayerBonusNumber(46, List.of(1, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
