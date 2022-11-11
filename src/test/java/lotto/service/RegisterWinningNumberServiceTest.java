package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterWinningNumberServiceTest extends NsTest {
    RegisterWinningNumberService registerWinningNumberService;

    public RegisterWinningNumberServiceTest() {
        this.registerWinningNumberService = new RegisterWinningNumberService();
    }

    @Test
    @DisplayName("당첨번호와 보너스번호 등록하기")
    void test1() {
        // given
        run("1,2,3,4,5,6", "7");

        // when
        WinningLotto winningLotto = registerWinningNumberService.register();

        // then
        assertThat(winningLotto)
                .usingRecursiveComparison()
                .isEqualTo(new WinningLotto("1,2,3,4,5,6", "7"));
    }

    @Test
    @DisplayName("당첨번호에 보너스번호가 포함될 때 exception과 에러메세지가 출력 되야 한다.")
    void test2() {
        // given
        run("1,2,3,4,5,6", "6");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, () -> registerWinningNumberService.register());
        assertEquals("[ERROR] 보너스 번호에 중복 된 숫자가 포함되어있습니다.", exception.getMessage());
    }

    @Override
    protected void runMain() {

    }
}