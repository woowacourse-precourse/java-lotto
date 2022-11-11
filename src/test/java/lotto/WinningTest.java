package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
[당첨번호 TEST]
1. 정상입력
2. 문자를 포함한 당첨번호 입력
3. 구분자를 (,) 가 아닌 구분자 입력
4. 6자리수가 아닌 당첨번호 입력
5. 당첨 번호에서 중복된 숫자가 포함될 경우
6. 당첨 번호가 1~45의 범위를 초과한 경우

[보너스 번호 TEST]
1. 정상 입력
2. 보너스 번호 문자 입력
3. 보너스 번호 1~45 범위 초과한 입력
4. 보너스 번호가 당첨 번호에 포함될 경우
* */

public class WinningTest {

    // 당첨 번호 입력 테스트
    @DisplayName("당첨번호 정상 입력")
    @Test
    void 당첨번호_정상입력() {
        Winning winning = new Winning();
        String winningInput = "1,2,38,4,5,6";
        winning.initializeWinningNumber(winningInput);

        assertThat(winning.getWinningNumbers().toString()).isEqualTo("[1, 2, 38, 4, 5, 6]");
    }

    @DisplayName("당첨번호 비정상 입력(문자 입력)")
    @Test
    void 당첨번호_비정상입력_문자() {
        Winning winning = new Winning();
        String winningInput = "1,d,38,4,5,6";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 비정상 입력(, 가 아닌 구분문자)")
    @Test
    void 당첨번호_비정상입력_구분자() {
        Winning winning = new Winning();
        String winningInput = "1.20.38.4.5.6";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput))
                .isInstanceOf(IllegalArgumentException.class);

        String winningInput2 = "1#20#38#4#5#6";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 비정상 입력(6자리가 아닌 수 입력)")
    @Test
    void 당첨번호_비정상입력_안콤마() {
        Winning winning = new Winning();

        String winningInput = "1,20,38,4,5,6,9,15";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput))
                .isInstanceOf(IllegalArgumentException.class);

        String winningInput2 = "5,6,9,15";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 비정상 입력(중복 번호 포함)")
    @Test
    void 당첨번호_비정상입력_중복() {
        Winning winning = new Winning();

        String winningInput = "1,11,32,43,22,1";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 비정상 입력(범위 초과)")
    @Test
    void 당첨번호_비정상입력_범위초과() {
        Winning winning = new Winning();

        String winningInput = "1,11,32,46,22,32";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput))
                .isInstanceOf(IllegalArgumentException.class);

        String winningInput2 = "0,11,32,46,22,32";
        assertThatThrownBy(()-> winning.initializeWinningNumber(winningInput2))
                .isInstanceOf(IllegalArgumentException.class);
    }


    // 보너스 번호 입력 테스트
    @DisplayName("보너스 번호 정상 입력")
    @Test
    void 보너스번호_정상입력() {
        Winning winning = new Winning();
        String bonusNumber = "19";
        winning.initializeBonusNumber(bonusNumber);
        assertThat(winning.getBonusNumber()).isEqualTo(19);
    }


    @DisplayName("보너스 번호 비정상 입력(문자)")
    @Test
    void 보너스번호_비정상입력_문자() {
        Winning winning = new Winning();

        String bonusNumber = "a";
        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String bonusNumber2 = ".";
        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber2))
                .isInstanceOf(IllegalArgumentException.class);

        String bonusNumber3 = "1 2";
        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 비정상 입력(범위초과)")
    @Test
    void 보너스번호_비정상입력_범위초과() {
        Winning winning = new Winning();

        String bonusNumber = "0";
        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

        String bonusNumber2 = "46";
        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 비정상 입력(당첨번호와 중복된 보너스 번호)")
    @Test
    void 보너스번호_비정상입력_당첨번호_중복() {
        Winning winning = new Winning();

        String winningNumber = "1,13,3,4,5,6";
        String bonusNumber = "5";
        winning.initializeWinningNumber(winningNumber);

        assertThatThrownBy(()-> winning.initializeBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
