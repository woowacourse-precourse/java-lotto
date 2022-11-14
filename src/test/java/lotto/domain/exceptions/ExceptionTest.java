package lotto.domain.exceptions;

import lotto.domain.StartLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static lotto.domain.exceptions.Exception.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    @DisplayName("잘못된 로또 구매금액 입력 시 예외가 발생한다.")
    @Test
    void paymentInputCheck_예외처리_테스트1() {
        assertThatThrownBy(() -> paymentInputCheck("15000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void paymentInputCheck_예외처리_테스트2() {
        assertThatThrownBy(() -> paymentInputCheck("15500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 당첨 번호 입력 시 예외가 발생한다.")
    @Test
    void winNumInputErrorCheck_예외처리_테스트1() {
        assertThatThrownBy(() -> winNumInputErrorCheck("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumInputErrorCheck_예외처리_테스트2() {
        assertThatThrownBy(() -> winNumInputErrorCheck("1,2,b,4,a,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumInputErrorCheck_예외처리_테스트3() {
        assertThatThrownBy(() -> winNumInputErrorCheck("1,2,3,4,5,47"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumInputErrorCheck_예외처리_테스트4() {
        assertThatThrownBy(() -> winNumInputErrorCheck("1,2,3,4,5,2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumInputErrorCheck_예외처리_테스트5() {
        assertThatThrownBy(() -> winNumInputErrorCheck("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void winNumInputErrorCheck_예외처리_테스트6() {
        assertThatThrownBy(() -> winNumInputErrorCheck("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 보너스 번호 입력 시 예외가 발생한다.")
    @Test
    void bonusErrorCheck_예외처리_테스트1() {
        assertThatThrownBy(() -> bonusErrorCheck("3k"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusErrorCheck_예외처리_테스트2() {
        assertThatThrownBy(() -> bonusErrorCheck("68"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void bonusErrorCheck_예외처리_테스트3() {
        StartLotto.winNums = new ArrayList<>();
        StartLotto.winNums.add(12);
        StartLotto.winNums.add(19);
        StartLotto.winNums.add(36);
        StartLotto.winNums.add(41);
        StartLotto.winNums.add(15);
        StartLotto.winNums.add(30);
        assertThatThrownBy(() -> bonusErrorCheck("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}