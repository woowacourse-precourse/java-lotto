package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.domain.WinningNumberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberServiceTest{

    WinningNumberService winningNumberService = new WinningNumberService();

    @DisplayName("당첨번호 숫자가 아닌 input 테스트")
    @Test
    void 당첨번호_숫자가_아닌_경우_에러_테스트(){

        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        String input = "숫자,아님,숫자,아님,숫자,아님";
        assertThatThrownBy(() -> winningNumberService.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("보너스 번호 숫자가 아닌 input 테스트")
    @Test
    void 보너스_숫자가_아닌_경우_에러_테스트(){
        String input = "숫자 아님";
        assertThatThrownBy(() -> winningNumberService.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 범위 벗어난 경우 테스트")
    @Test
    void 보너스_범위_벗어난_경우_에러_테스트(){
        String input = "60";
        assertThatThrownBy(() -> winningNumberService.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기존 로또 번호와 중복된 보너스 번호 에러 테스트")
    @Test
    void 중복된_보너스_번호_에러_테스트(){
        winningNumberService.parseWinningNumber("1,2,3,4,5,6");
        String input = "6";
        assertThatThrownBy(() -> winningNumberService.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
