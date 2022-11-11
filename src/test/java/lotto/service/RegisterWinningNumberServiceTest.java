package lotto.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Override
    protected void runMain() {

    }
}