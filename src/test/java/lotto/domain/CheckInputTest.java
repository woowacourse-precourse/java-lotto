package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckInputTest {
    @Test
    void checkPurchaseAmountPattern_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountPattern("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountRange_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountRange(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountUnit_예외_테스트() {
        assertThatThrownBy(() -> new CheckInput().checkPurchaseAmountUnit(5500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkPurchaseAmountValid_테스트() {
        assertThat(new CheckInput().checkPurchaseAmountValid("5000")).isEqualTo(5000);
    }

    @DisplayName("콤마(,)와 숫자 이 외의 문자가 있으면 예외가 발생한다.")
    @Test
    void checkWinningNumberValid_예외_테스트1() {
        assertThatThrownBy(() -> new CheckInput().checkWinningNumberValid("1,2,3,j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값을 콤마(,)로 split한 배열의 사이즈가 6이 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberValid_예외_테스트2() {
        assertThatThrownBy(() -> new CheckInput().checkWinningNumberValid("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 ~ 45 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void checkWinningNumberValid_예외_테스트3() {
        assertThatThrownBy(() -> new CheckInput().checkWinningNumberValid("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkWinningNumberValid_테스트() {
        List<Integer> check = List.of(1,2,3,4,5,6);
        assertThat(new CheckInput().checkWinningNumberValid("1,2,3,4,5,6")).isEqualTo(check);
    }

    @DisplayName("보너스 번호 입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void checkBonusNumberValid_예외_테스트1() {
        assertThatThrownBy(() -> new CheckInput().checkWinningNumberValid("j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력값이 1 ~ 45 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void checkBonusNumberValid_예외_테스트2() {
        assertThatThrownBy(() -> new CheckInput().checkWinningNumberValid("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}